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
import com.june.entity.BibleVerse;
import com.june.service.BibleBookService;
import com.june.service.BibleChapterService;
import com.june.service.BibleVerseService;

@Controller
@RequestMapping(value = "/bibleVerse")
public class BibleVerseController {

    @Autowired
    private BibleVerseService bibleVerseService;

    @Autowired
    private BibleBookService bibleBookService;
    

    @Autowired
    private BibleChapterService bibleChapterService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<BibleVerse> bibleVerses = bibleVerseService.getAllBibleVerse();
        model.addAttribute("bibleVerses", bibleVerses);
        return "bibleVerse/bibleVerseList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addBibleVerse(Model model) {
        List<BibleChapter> chapters = bibleChapterService.getAllBibleChapter();
        model.addAttribute("chapters", chapters);
        model.addAttribute("bibleVerse", new BibleVerse());
        model.addAttribute("action", "create");
        return "bibleVerse/bibleVerseForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(BibleVerse newBibleVerse,RedirectAttributes redirectAttributes) {
        bibleVerseService.saveBibleVerse(newBibleVerse);
        redirectAttributes.addFlashAttribute("message",
                "Create BibleVerse Success!");
        return "redirect:/bibleVerse/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        List<BibleBook> books = bibleBookService.getAllBibleBook();
        List<BibleChapter> chapters = bibleChapterService.getAllBibleChapter();
        model.addAttribute("books", books);
        model.addAttribute("chapters", chapters);
        model.addAttribute("bibleVerse", bibleVerseService.getBibleVerse(id));
        model.addAttribute("action", "update");
        return "bibleVerse/bibleVerseForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(
            @Valid @ModelAttribute("bibleVerse") BibleVerse bibleVerse) {
        bibleVerseService.saveBibleVerse(bibleVerse);
        return "redirect:/bibleVerse";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        bibleVerseService.deleteBibleVerse(id);
        redirectAttributes.addFlashAttribute("message",
                "Delete BibleVerse Success!");
        return "redirect:/bibleVerse";
    }

    @ModelAttribute
    public void getBibleVerse(
            @RequestParam(value = "id", defaultValue = "-1") Long id,
            Model model) {
        if (id != -1) {
            model.addAttribute("bibleVerse",
                    bibleVerseService.getBibleVerse(id));
        }
    }
}