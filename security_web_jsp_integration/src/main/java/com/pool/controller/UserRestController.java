package com.pool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pool.exception.UserNotFoundException;
import com.pool.form.UserForm;
import com.pool.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;

	@PostMapping("/saveuser")
	public UserForm saveUser(@RequestBody UserForm userForm) {
		UserForm userform = userService.saveUser(userForm);
		return userform;
	}

	@GetMapping("/user/{userId}")
	public UserForm user(@PathVariable("userId") Integer userId) {
		UserForm user = userService.getUser(userId);
		if (user == null) {
			throw new UserNotFoundException("USER NOT FOUND WITH USER ID:"+userId);
		}

		return user;
	}

	public String uploadProfilePic() {
		return null;
	}
	}
