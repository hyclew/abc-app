package org.kbs.app.web.security.sample.web;

import org.kbs.app.web.security.sample.domain.User;
import org.kbs.app.web.security.sample.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private SecurityUserService userService;
	@PreAuthorize("hasAuthority('USER_QUERY')")
	@RequestMapping("/list")
	public String list(Model model,Pageable pageable){
		model.addAttribute("page",userService.findAll(pageable));
		return "user/list";
	}
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("action","add");
		return "user/save";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(User user,boolean passNonUpdate){
		if (!passNonUpdate) {//需要更新密码
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		userService.save(user);
		return "redirect:list";
	}
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String update(Model model,Long id){
		model.addAttribute("action","update");
		model.addAttribute("user",userService.findOne(id));
		return "user/save";
	}
	@RequestMapping(value = "/delete")
	public String delete(Long id){
		userService.delete(id);
		return "redirect:list";
	}
}
