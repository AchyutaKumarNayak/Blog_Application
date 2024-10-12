package in.achyuta.service;

import in.achyuta.binding.LoginForm;
import in.achyuta.binding.RegistrationForm;
import in.achyuta.entity.User;

public interface UserService {

	boolean register(RegistrationForm form);
	
	String login(LoginForm form);

	User getUserById(Integer userId);
	
	

}
