package com.june.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.june.entity.Log;
import com.june.entity.User;
import com.june.service.LogService;
import com.june.service.UserService;

@Controller
@RequestMapping(value = "/log")
public class LogController {

	@Autowired
	private LogService logService;

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Log> logs = logService.getAllLog();
		model.addAttribute("logs", logs);
		return "log/logList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String addLog(Model model) {
		model.addAttribute("log", new Log());
		model.addAttribute("action", "create");
		return "log/logForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(Log newLog, RedirectAttributes redirectAttributes) {
		newLog.setLogType("default");
		newLog.setStartTime(new Date());
		newLog.setEndTime(new Date());
		User user = userService.findUserByLoginName("user");
		newLog.setUser(user);
		logService.saveLog(newLog);
		redirectAttributes.addFlashAttribute("message", "Create Log Success!");
		return "redirect:/log/";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("log", logService.getLog(id));
		model.addAttribute("action", "update");
		return "log/logForm";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("log") Log log,
			RedirectAttributes redirectAttributes) {
		logService.saveLog(log);
		redirectAttributes.addFlashAttribute("message",
				"Update Log" + log.getTitle() + "Success");
		return "redirect:/log/";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes) {
		logService.deleteLog(id);
		redirectAttributes.addFlashAttribute("message", "Delete Log Success!");
		return "redirect:/log/";
	}
}