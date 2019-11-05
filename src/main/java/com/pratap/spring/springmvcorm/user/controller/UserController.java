package com.pratap.spring.springmvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pratap.spring.springmvcorm.user.entity.User;
import com.pratap.spring.springmvcorm.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("registrationPage")
	public String showRegistrationPage() {
		return "userReg";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, ModelMap modelMap) {
		int result = service.save(user);
		modelMap.addAttribute("result", "User Created With Id" + result);

		return "userReg";
	}

	@RequestMapping("getUsers")
	public String getUser(ModelMap modelMap) {
		List<User> users = service.getUser();
		modelMap.addAttribute("users", users);
		return "displayUsers";
	}

	@RequestMapping("validateEmail")
	public @ResponseBody String validateEmail(@RequestParam("id") Integer id) {
		User user = service.getUser(id);
		String msg = "";
		if (user != null) {
			msg += id + " already exist";
		}
		return msg;
	}
}
