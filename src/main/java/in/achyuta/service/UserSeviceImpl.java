package in.achyuta.service;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.achyuta.binding.LoginForm;
import in.achyuta.binding.RegistrationForm;
import in.achyuta.constants.AppConstants;
import in.achyuta.entity.User;
import in.achyuta.repository.UserRepo;
import javax.servlet.http.HttpSession;

@Service
public class UserSeviceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private HttpSession session;

	@Override
	public boolean register(RegistrationForm form) {
		User user = userRepo.findByEmail(form.getEmail());
		if(null!=user) {
			return false;
		}
		User entity= new User();
		BeanUtils.copyProperties(form, entity);
		userRepo.save(entity);
		return true;
	}

	@Override
	public String login(LoginForm form) {
		User user = userRepo.findByEmailAndPassword(form.getEmail(), form.getPassword());
		if(null==user) {
			return AppConstants.USER_SERVICE_IMPL_FLAG_FAILURE;
		}
		session.setAttribute("userId", user.getUserId());
		return AppConstants.USER_CONTROLLER_FLAG_SUCCESS;
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepo.findById(userId).get();
	}

}
