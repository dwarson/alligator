package com.june.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.june.entity.Link;
import com.june.entity.Topic;
import com.june.service.LinkService;
import com.june.service.TopicService;
import com.june.service.UserService;
import com.june.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        Map<String, List<Link>> links = new HashMap<String, List<Link>>();
        List<Topic> linkTypes = topicService.getAllTopic();
        List<Link> allLink = linkService.getAllLink();
        for (Topic topic : linkTypes) {
            List<Link> linkList = new ArrayList<Link>();
            for (Link link : allLink) {
                if (topic.getId().equals(link.getLinkType().getId())) {
                    linkList.add(link);
                }
            }
            links.put(topic.getTitle(), linkList);
        }
        model.addAttribute("links", links);
        return "link/links";
    }

    @RequestMapping(value = "manage", method = RequestMethod.GET)
    public String manage(Model model) {
        List<Link> links = linkService.getAllLink();
        model.addAttribute("links", links);
        return "link/linkList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addLink(Model model) {
        List<Topic> linkTypes = topicService.getAllTopic();
        model.addAttribute("linkTypes", linkTypes);
        model.addAttribute("link", new Link());
        model.addAttribute("action", "create");
        return "link/linkForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Link newLink, RedirectAttributes redirectAttributes) {
        Long id = getCurrentUserId();
        newLink.setUser(userService.getUser(id));
        linkService.saveLink(newLink);
        redirectAttributes.addFlashAttribute("message", "Create Link Success!");
        return "redirect:/link/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("link", linkService.getLink(id));
        List<Topic> linkTypes = topicService.getAllTopic();
        model.addAttribute("linkTypes", linkTypes);
        model.addAttribute("action", "update");
        return "link/linkForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("link") Link link) {
        linkService.saveLink(link);
        return "redirect:/link";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        linkService.deleteLink(id);
        redirectAttributes.addFlashAttribute("message", "Delete Link Success!");
        return "redirect:/link";
    }

    @ModelAttribute
    public void getLink(
            @RequestParam(value = "id", defaultValue = "-1") Long id,
            Model model) {
        if (id != -1) {
            model.addAttribute("link", linkService.getLink(id));
        }
    }

    private Long getCurrentUserId() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }
}