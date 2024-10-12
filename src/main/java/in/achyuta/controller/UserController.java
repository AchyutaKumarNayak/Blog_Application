package in.achyuta.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.achyuta.binding.LoginForm;
import in.achyuta.binding.RegistrationForm;
import in.achyuta.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("user", new RegistrationForm());
		return "registration";
	}
	@PostMapping("/register")
	public String registerHandler(@ModelAttribute("user") RegistrationForm form, Model model) {
		System.out.println(form);
		boolean status = userService.register(form);
		if(status) {
			model.addAttribute("succMsg", "Regestration Succesfull");
		}else {
			model.addAttribute("errMsg", "Choose Unique Email");
		}
		return "registration";
	}
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("login", new LoginForm());
		return "login";
	}
	@PostMapping("/login")
	public String Login(@ModelAttribute("login") LoginForm form, Model model) {
		String msg = userService.login(form);
		if(msg.contains("success")) {
			return "redirect:/dashboard";
		}else {
			model.addAttribute("errMsg", msg);
		}
		return "login";
	}

}
