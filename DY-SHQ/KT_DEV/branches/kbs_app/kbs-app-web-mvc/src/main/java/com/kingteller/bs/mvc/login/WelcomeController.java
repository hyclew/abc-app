package com.kingteller.bs.mvc.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kingteller.bs.domain.login.User;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.mvc.util.Constants;
import com.kingteller.bs.service.WelcomeControllerService;

@Controller
@RequestMapping("/welcome")
//将Model中属性名为Constants.USER_INFO_SESSION的
//属性放到Session属性列表中，以便这个属性可以跨请求访问
@SessionAttributes(value = {Constants.USER_INFO_SESSION})
public class WelcomeController {
	
	@Autowired
	private WelcomeControllerService welcomeControllerService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String helloWorld(User user,Model model) throws Exception {
		
		LoginUser loginUser =  welcomeControllerService.queryUserByNameAndPwd(user.getName(), user.getPassword());
		
		if(loginUser != null){
			if (loginUser.getUsername().equals(user.getName()) && loginUser.getUsername().equals(user.getPassword())) {
				model.addAttribute(Constants.USER_INFO_SESSION, loginUser); //名为Constants.USER_INFO_SESSION的属性放到Session属性列表中
				return "/welcome";
			}
		}else{
			model.addAttribute("message", "用户不存在");
			return "/relogin";
		}
		return null;
	}
}

