package org.kbs.app.web.security.sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class DefaultController {
	@Autowired(required = false)
	private SessionRegistry sessionRegistry;
	@RequestMapping("/")
	public String index(Model model){
		int numOfUsers=sessionRegistry.getAllPrincipals().size();
		model.addAttribute("numOfUsers",numOfUsers);
		return "index";
	}
}
