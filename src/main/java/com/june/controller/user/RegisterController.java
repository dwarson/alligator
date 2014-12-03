package com.june.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.june.entity.User;
import com.june.service.UserService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String registerForm() {
        return "user/register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid User user,
            RedirectAttributes redirectAttributes) {
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("username", user.getUsername());
        return "redirect:/login";
    }

    /**
     * Ajax request ,validate unique username
     */
    @RequestMapping(value = "checkUsername")
    @ResponseBody
    public String checkLoginName(@RequestParam("username") String username) {
        if (userService.findUserByUsername(username) == null) {
            return "true";
        } else {
            return "false";
        }
    }
}
