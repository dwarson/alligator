package com.june.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.june.entity.User;
import com.june.service.UserService;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	private UserService userService;

	// need to figure out how to get forwarded here with the current principle
	// user.
	@RequestMapping({ "/", "/login" })
	public String viewAccount(Model model) {
		User a = new User();
		model.addAttribute(a);
		return "login";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String login(User user, Model mode) throws BindException {
		User user2 = userService.findUserByLoginName(user.getUsername());
		if (user2 != null && user.getPassword().equals(user2.getPassword())) {
			mode.addAttribute(user2);
			return "user";
		}
		return "login";
	}

}