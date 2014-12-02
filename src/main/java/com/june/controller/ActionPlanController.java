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

import com.june.entity.ActionPlan;
import com.june.entity.Thought;
import com.june.service.ActionPlanService;
import com.june.service.ThoughtService;
import com.june.service.UserService;
import com.june.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/actionPlan")
public class ActionPlanController {

	@Autowired
	private ActionPlanService actionPlanService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ThoughtService thoughtService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<ActionPlan> actionPlans = actionPlanService.getAllActionPlan();
		model.addAttribute("actionPlans", actionPlans);
		return "actionPlan/actionPlanList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String addActionPlan(Model model) {
		int[ ] actionPlanTypes = {1,2,3,4};
		model.addAttribute("actionPlanTypes", actionPlanTypes);
		model.addAttribute("actionPlan", new ActionPlan());
		model.addAttribute("action", "create");
		return "actionPlan/actionPlanForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(ActionPlan newActionPlan,
			RedirectAttributes redirectAttributes) {
		Long id = getCurrentUserId();
		newActionPlan.setUser(userService.getUser(id));
		newActionPlan.setThought(thoughtService.getThought(new Long(33)));//TODO: get thought
		actionPlanService.saveActionPlan(newActionPlan);
		redirectAttributes.addFlashAttribute("message",
				"Create ActionPlan Success!");
		return "redirect:/actionPlan/";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("actionPlan", actionPlanService.getActionPlan(id));
		int[ ] actionPlanTypes = {1,2,3,4};
		model.addAttribute("actionPlanTypes", actionPlanTypes);
		model.addAttribute("action", "update");
		return "actionPlan/actionPlanForm";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("actionPlan") ActionPlan actionPlan) {
		actionPlanService.saveActionPlan(actionPlan);
		return "redirect:/actionPlan";
	}
	
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes) {
		actionPlanService.deleteActionPlan(id);
		redirectAttributes.addFlashAttribute("message",
				"Delete ActionPlan Success!");
		return "redirect:/actionPlan";
	}

	@ModelAttribute
	public void getActionPlan(
			@RequestParam(value = "id", defaultValue = "-1") Long id,
			Model model) {
		if (id != -1) {
			model.addAttribute("actionPlan", actionPlanService.getActionPlan(id));
		}
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
}