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

import com.june.entity.BibleBook;
import com.june.entity.BibleChapter;
import com.june.service.BibleBookService;
import com.june.service.BibleChapterService;

@Controller
@RequestMapping(value = "/bible")
public class BibleController {

    @Autowired
    private BibleBookService bibleBookService;

    @Autowired
    private BibleChapterService bibleChapterService;

    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<BibleBook> bibleBooks = bibleBookService.getAllBibleBook();
        model.addAttribute("bibleBooks", bibleBooks);
        return "bible/bibleList";
    }

    @RequestMapping(value = "read/{id}", method = RequestMethod.GET)
    public String readBook(@PathVariable("id") Long id, Model model) {
        List<BibleBook> books = bibleBookService.getAllBibleBook();
        model.addAttribute("books", books);
        model.addAttribute("bibleChapter",
                bibleChapterService.getBibleChapter(id));
        model.addAttribute("action", "read");
        return "bibleChapter/bibleChapterForm";
    }

    @RequestMapping(value = "read", method = RequestMethod.POST)
    public String readBook(@Valid @ModelAttribute("bibleChapter") BibleChapter bibleChapter) {
        bibleChapterService.saveBibleChapter(bibleChapter);
        return "redirect:/bible";
    }

    @ModelAttribute
    public void getBibleBook(
            @RequestParam(value = "id", defaultValue = "-1") Long id,
            Model model) {
        if (id != -1) {
            model.addAttribute("bibleBook", bibleBookService.getBibleBook(id));
        }
    }
}