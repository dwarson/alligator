package com.june.controller.user;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.june.entity.User;
import com.june.service.UserService;
import com.june.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/profile")
public class UserController {

	@Autowired
	private UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String updateForm(Model model) {
        Long id = getCurrentUserId();
        model.addAttribute("user", userService.getUser(id));
        return "user/profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("user") User user) {
        userService.updateUser(user);
        updateCurrentUserName(user.getName());
        return "redirect:/";
    }


    @ModelAttribute
    public void getUser(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("user", userService.getUser(id));
        }
    }


    private Long getCurrentUserId() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }

    private void updateCurrentUserName(String userName) {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        user.name = userName;
    }
}