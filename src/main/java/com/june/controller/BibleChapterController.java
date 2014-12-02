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

import com.june.entity.BibleBook;
import com.june.entity.BibleChapter;
import com.june.service.BibleBookService;
import com.june.service.BibleChapterService;

@Controller
@RequestMapping(value = "/bibleChapter")
public class BibleChapterController {

    @Autowired
    private BibleChapterService bibleChapterService;

    @Autowired
    private BibleBookService bibleBookService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<BibleChapter> bibleChapters = bibleChapterService
                .getAllBibleChapter();
        model.addAttribute("bibleChapters", bibleChapters);
        return "bibleChapter/bibleChapterList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addBibleChapter(Model model) {
        List<BibleBook> books = bibleBookService.getAllBibleBook();
        model.addAttribute("books", books);
        model.addAttribute("bibleChapter", new BibleChapter());
        model.addAttribute("action", "create");
        return "bibleChapter/bibleChapterForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(BibleChapter newBibleChapter,
            RedirectAttributes redirectAttributes) {
        bibleChapterService.saveBibleChapter(newBibleChapter);
        redirectAttributes.addFlashAttribute("message",
                "Create BibleChapter Success!");
        return "redirect:/bibleChapter/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        List<BibleBook> books = bibleBookService.getAllBibleBook();
        model.addAttribute("books", books);
        model.addAttribute("bibleChapter",
                bibleChapterService.getBibleChapter(id));
        model.addAttribute("action", "update");
        return "bibleChapter/bibleChapterForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(
            @Valid @ModelAttribute("bibleChapter") BibleChapter bibleChapter) {
        bibleChapterService.saveBibleChapter(bibleChapter);
        return "redirect:/bibleChapter";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        bibleChapterService.deleteBibleChapter(id);
        redirectAttributes.addFlashAttribute("message",
                "Delete BibleChapter Success!");
        return "redirect:/bibleChapter";
    }

    @ModelAttribute
    public void getBibleChapter(
            @RequestParam(value = "id", defaultValue = "-1") Long id,
            Model model) {
        if (id != -1) {
            model.addAttribute("bibleChapter",
                    bibleChapterService.getBibleChapter(id));
        }
    }
}