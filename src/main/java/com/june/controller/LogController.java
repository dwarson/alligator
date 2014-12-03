package com.june.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.june.entity.Log;
import com.june.entity.Topic;
import com.june.service.LogService;
import com.june.service.TopicService;
import com.june.service.UserService;
import com.june.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/log")
public class LogController {

    @Autowired
    private LogService logService;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Log> logs = logService.getAllLog();
        model.addAttribute("logs", logs);
        return "log/logList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addLog(Model model) {
        List<Topic> logTypes = topicService.getAllTopic();
        model.addAttribute("logTypes", logTypes);
        model.addAttribute("log", new Log());
        model.addAttribute("action", "create");
        return "log/logForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Log newLog, RedirectAttributes redirectAttributes) {
        Long id = getCurrentUserId();
        newLog.setUser(userService.getUser(id));
        logService.saveLog(newLog);
        redirectAttributes.addFlashAttribute("message", "Create Log Success!");
        return "redirect:/log/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("log", logService.getLog(id));
        List<Topic> logTypes = topicService.getAllTopic();
        model.addAttribute("logTypes", logTypes);
        model.addAttribute("action", "update");
        return "log/logForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("log") Log log) {
        logService.saveLog(log);
        return "redirect:/log";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        logService.deleteLog(id);
        redirectAttributes.addFlashAttribute("message", "Delete Log Success!");
        return "redirect:/log";
    }

    @ModelAttribute
    public void getLog(
            @RequestParam(value = "id", defaultValue = "-1") Long id,
            Model model) {
        if (id != -1) {
            model.addAttribute("log", logService.getLog(id));
        }
    }

    private Long getCurrentUserId() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }
}