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

import com.june.entity.Topic;
import com.june.service.TopicService;

@Controller
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Topic> topics = topicService.getAllTopic();
        model.addAttribute("topics", topics);
        return "topic/topicList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addTopic(Model model) {
        model.addAttribute("topic", new Topic());
        model.addAttribute("action", "create");
        return "topic/topicForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Topic newTopic, RedirectAttributes redirectAttributes) {
        topicService.saveTopic(newTopic);
        redirectAttributes
                .addFlashAttribute("message", "Create Topic Success!");
        return "redirect:/topic/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("topic", topicService.getTopic(id));
        model.addAttribute("action", "update");
        return "topic/topicForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("topic") Topic topic) {
        topicService.saveTopic(topic);
        return "redirect:/topic";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        topicService.deleteTopic(id);
        redirectAttributes
                .addFlashAttribute("message", "Delete Topic Success!");
        return "redirect:/topic";
    }

    @ModelAttribute
    public void getTopic(
            @RequestParam(value = "id", defaultValue = "-1") Long id,
            Model model) {
        if (id != -1) {
            model.addAttribute("topic", topicService.getTopic(id));
        }
    }
}