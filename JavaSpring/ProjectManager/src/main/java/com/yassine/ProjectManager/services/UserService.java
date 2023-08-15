package com.yassine.ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.yassine.ProjectManager.models.LoginUser;
import com.yassine.ProjectManager.models.User;
import com.yassine.ProjectManager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	// TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {

		Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "registerError", "Email is Taken");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "registerError", "password does not match");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			String hashdPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashdPW);
			return userRepository.save(newUser);

		}

	}

	public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> potentialLogin = userRepository.findByEmail(newLoginObject.getEmail());
		if (!potentialLogin.isPresent()) {
			result.rejectValue("email", "loginError", "email not found");
		} else {
			User actualUser = potentialLogin.get();
			if (!BCrypt.checkpw(newLoginObject.getPassword(), actualUser.getPassword())) {
				result.rejectValue("password", "loginError", "password incorrect");
			} if (result.hasErrors()) {
				return null;
			} else {
				return actualUser;
			}
		}
		return null;
	}
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else 
			return null;
		
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}