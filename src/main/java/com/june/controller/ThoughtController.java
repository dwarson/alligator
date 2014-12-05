package com.june.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.june.entity.Thought;
import com.june.entity.Topic;
import com.june.service.ThoughtService;
import com.june.service.TopicService;
import com.june.service.UserService;

@Controller
@RequestMapping(value = "/thought")
public class ThoughtController extends BaseController {

    @Autowired
    private ThoughtService thoughtService;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        Long id = getCurrentUserId();
        List<Thought> thoughts = thoughtService.getAllByUser(userService
                .getUser(id));
        model.addAttribute("thoughts", thoughts);
        return "thought/thoughtList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addThought(Model model) {
        List<Topic> thoughtTypes = topicService.getAllTopic();
        model.addAttribute("thoughtTypes", thoughtTypes);
        model.addAttribute("thought", new Thought());
        model.addAttribute("action", "create");
        return "thought/thoughtForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Thought newThought,
            RedirectAttributes redirectAttributes) {
        Long id = getCurrentUserId();
        newThought.setUser(userService.getUser(id));
        thoughtService.saveThought(newThought);
        redirectAttributes.addFlashAttribute("message",
                "Create Thought Success!");
        return "redirect:/thought/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("thought", thoughtService.getThought(id));
        List<Topic> thoughtTypes = topicService.getAllTopic();
        model.addAttribute("thoughtTypes", thoughtTypes);
        model.addAttribute("action", "update");
        return "thought/thoughtForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("thought") Thought thought) {
        thoughtService.saveThought(thought);
        return "redirect:/thought";
    }

    @RequestMapping(value = "process/{id}", method = RequestMethod.GET)
    public String processForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("thought", thoughtService.getThought(id));
        List<Topic> thoughtTypes = topicService.getAllTopic();
        model.addAttribute("thoughtTypes", thoughtTypes);
        model.addAttribute("action", "process");
        return "thought/thoughtForm";
    }

    @RequestMapping(value = "process", method = RequestMethod.POST)
    public String process(@Valid @ModelAttribute("thought") Thought thought) {
        thoughtService.saveThought(thought);
        return "redirect:/thought";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        thoughtService.deleteThought(id);
        redirectAttributes.addFlashAttribute("message",
                "Delete Thought Success!");
        return "redirect:/thought";
    }

    @ModelAttribute
    public void getThought(
            @RequestParam(value = "id", defaultValue = "-1") Long id,
            Model model) {
        if (id != -1) {
            model.addAttribute("thought", thoughtService.getThought(id));
        }
    }

}