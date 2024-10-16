package in.achyuta.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.achyuta.binding.LoginForm;
import in.achyuta.binding.RegistrationForm;
import in.achyuta.constants.AppConstants;
import in.achyuta.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute(AppConstants.USER_CONTROLLER_USER, new RegistrationForm());
		return AppConstants.USER_CONTROLLER_REGISTRATION;
	}
	@PostMapping("/register")
	public String registerHandler(@ModelAttribute(AppConstants.USER_CONTROLLER_USER) RegistrationForm form, Model model) {
		System.out.println(form);
		boolean status = userService.register(form);
		if(status) {
			model.addAttribute(AppConstants.SUCC_MSG_KEY, AppConstants.SUCC_MSG_VALUE_REGISTRATION);
		}else {
			model.addAttribute(AppConstants.ERR_MSG_KEY, AppConstants.ERR_MSG_VALUE_REGISTRATION);
		}
		return AppConstants.USER_CONTROLLER_REGISTRATION;
	}
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute(AppConstants.USER_CONTROLLER_LOGIN, new LoginForm());
		return AppConstants.USER_CONTROLLER_LOGIN;
	}
	@PostMapping("/login")
	public String Login(@ModelAttribute(AppConstants.USER_CONTROLLER_LOGIN) LoginForm form, Model model) {
		String msg = userService.login(form);
		if(msg.contains(AppConstants.USER_CONTROLLER_FLAG_SUCCESS)) {
			return "redirect:/dashboard";
		}else {
			model.addAttribute(AppConstants.ERR_MSG_KEY, msg);
		}
		return AppConstants.USER_CONTROLLER_LOGIN;
	}

}
