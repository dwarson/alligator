package com.june.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String login(User user, BindingResult bindingResult)
            throws BindException {
        System.out.println("list users");
        List<User> users = userService.getAllUser();
        for (User user2 : users) {
            System.out.println(user2.getName());
        }
        System.out.println(bindingResult);
        if (bindingResult.hasErrors()) {
            System.out.println("has error");
            return "user";
        }
        

        return "user";
    }

}