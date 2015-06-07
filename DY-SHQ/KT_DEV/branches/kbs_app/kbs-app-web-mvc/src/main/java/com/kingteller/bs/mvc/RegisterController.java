package com.kingteller.bs.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kingteller.bs.domain.EnterpriseInfo;
import com.kingteller.bs.domain.Mail;
import com.kingteller.bs.domain.UserAccount;
import com.kingteller.bs.mvc.util.PhoneAuthCodeUtil;

@Controller
@RequestMapping(value = "/base")
public class RegisterController {

	private static Logger logger = LoggerFactory
			.getLogger(RegisterController.class);

//	@Autowired
//	private VelocityEngine velocityEngine;
	/*
	@Autowired
	private IUserRegisterService userRegisterService;

	@Autowired
	private IEnterpriseInfoService enterpriseInfoService;
	
	@Autowired
	private IVirtualAccountService virtualAccountService;
	*/
	/**
	 * 路由到注册form
	 * 
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String registerForm(Model model) {
		return "/base/register.html";
	}

	/**
	 * 注册
	 * @param user
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView register(@Valid UserAccount user, EnterpriseInfo ent,
			@RequestParam("mobileCode") String mobileCode,
			RedirectAttributes redirectAttributes, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String phoneAuthCodeValidateStatus = PhoneAuthCodeUtil.validateAuthCode(session, mobileCode, user.getMobile());//手机验证码的校验状态
//		if(!phoneAuthCodeValidateStatus.equals("right")){
//			model.addAttribute("error", "3");
//			return new ModelAndView("/base/register.html");
//		}
		
		/*if (!mobileCode.equals(session.getAttribute(user.getMobile()))) {
			model.addAttribute("error", "3");
			return new ModelAndView("/base/register.html");
		}*/
		if(ent.getOrgCode()!=null&&ent.getActivateCode()!=null){
			user.setUserType("3");
			//验证组织机构代码和激活码
//			EnterpriseInfo entInfo=enterpriseInfoService.getEnterpriseInfoByOrgCode(ent.getOrgCode());
//			if(entInfo==null){
//				//机构不存在
//				model.addAttribute("error", "4");
//				model.addAttribute("showCode","1");
//				return new ModelAndView("/base/register.html");
//			}else if(!entInfo.getActivateCode().equals(ent.getActivateCode())){
//				//激活码不正确
//				model.addAttribute("error", "5");
//				model.addAttribute("showCode","1");
//				return new ModelAndView("/base/register.html");
//			}else if(entInfo.getActivateStatus().equals("1")){
//				//激活码已经被激活
//				model.addAttribute("error", "6");
//				model.addAttribute("showCode","1");
//				return new ModelAndView("/base/register.html");
//			}
		}
//		try {
//			//enterpriseInfoService.activateEnt(ent);
//			userRegisterService.registerUser(user,ent);
//		} catch (BusinessException e) {
//			if (e.getMessage() != null
//					&& (e.getMessage().equals("1") || e.getMessage()
//							.equals("2"))) {
//				model.addAttribute("error", e.getMessage());
//				return new ModelAndView("/base/register.html");
//			} else {
//				return new ModelAndView("redirect:/base/login");
//			}
//		}
		return new ModelAndView("redirect:/base/login");
	}

	/**
	 * Ajax请求校验userName是否唯一。
	 */
	@RequestMapping(value = "checkUserName")
	@ResponseBody
	public boolean checkUserName(@RequestParam("userName") String userName) {
		return true;//!userRegisterService.hasUserByName(userName);
	}

	/**
	 * Ajax请求校验mobile是否唯一。
	 */
	@RequestMapping(value = "checkMobile")
	@ResponseBody
	public boolean checkMobile(@RequestParam("mobile") String mobile) {
		return true;//!userRegisterService.hasUserByMobile(mobile);
	}
	
	/**
	 * Ajax请求校验email是否唯一。
	 */
	@RequestMapping(value = "checkEmail")
	@ResponseBody
	public boolean checkEmail(@RequestParam("email") String email) {
		return true;//!userRegisterService.hasUserByEmail(email);
	}

	/**
	 * 发送模板邮件
	 * 
	 */
	@RequestMapping(value = "sendRegisterEmail")
	public void sendRegisterEmail(@RequestParam("email") String email) {
		Mail mail = new Mail();
		mail.setTo(email);
		mail.setSubject("互联网金融账户激活邮件");
		mail.setTemplateName("mail.vm");

		Map<String, Object> model = new HashMap<String, Object>();
		String url = "";
		model.put("url", url);
		model.put("email", "test@abchina.com");

		String result = null;
//		try {
//			result = VelocityEngineUtils.mergeTemplateIntoString(
//					velocityEngine, mail.getTemplateName(), "UTF-8", model);
//		} catch (Exception e) {
//			logger.debug(e.getMessage());
//		}
//		mailSenderService.sendWithTemplate(model, mail, result);
	}

}
