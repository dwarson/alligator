package com.june.controller;

import java.util.Date;
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

import com.june.entity.Pray;
import com.june.entity.Topic;
import com.june.service.PrayService;
import com.june.service.TopicService;
import com.june.service.UserService;

@Controller
@RequestMapping(value = "/pray")
public class PrayController extends BaseController {

    @Autowired
    private PrayService prayService;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        Long id = getCurrentUserId();
        List<Pray> prays = prayService.getAllByUser(userService.getUser(id));
        model.addAttribute("prays", prays);
        return "pray/prayList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addPray(Model model) {
        List<Topic> prayTypes = topicService.getAllTopic();
        model.addAttribute("prayTypes", prayTypes);
        model.addAttribute("pray", new Pray());
        model.addAttribute("action", "create");
        return "pray/prayForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Pray newPray, RedirectAttributes redirectAttributes) {
        Long id = getCurrentUserId();
        newPray.setUser(userService.getUser(id));
        newPray.setStartTime(new Date());
        newPray.setUpdateTime(new Date());
        newPray.setStatus(0);
        prayService.savePray(newPray);
        redirectAttributes.addFlashAttribute("message", "Create Pray Success!");
        return "redirect:/pray/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("pray", prayService.getPray(id));
        List<Topic> prayTypes = topicService.getAllTopic();
        model.addAttribute("prayTypes", prayTypes);
        model.addAttribute("action", "update");
        return "pray/prayForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("pray") Pray pray) {
    	pray.setUpdateTime(new Date());
        prayService.savePray(pray);
        return "redirect:/pray";
    }

    @RequestMapping(value = "process/{id}", method = RequestMethod.GET)
    public String processForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("pray", prayService.getPray(id));
        List<Topic> prayTypes = topicService.getAllTopic();
        model.addAttribute("prayTypes", prayTypes);
        model.addAttribute("action", "process");
        return "pray/prayForm";
    }

    @RequestMapping(value = "process", method = RequestMethod.POST)
    public String process(@Valid @ModelAttribute("pray") Pray pray) {
    	pray.setUpdateTime(new Date());
        prayService.savePray(pray);
        return "redirect:/pray";
    }
    
    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        prayService.deletePray(id);
        redirectAttributes.addFlashAttribute("message", "Delete Pray Success!");
        return "redirect:/pray";
    }

    @ModelAttribute
    public void getPray(
            @RequestParam(value = "id", defaultValue = "-1") Long id,
            Model model) {
        if (id != -1) {
            model.addAttribute("pray", prayService.getPray(id));
        }
    }

}