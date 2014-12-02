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
import com.june.service.BibleBookService;

@Controller
@RequestMapping(value = "/bibleBook")
public class BibleBookController {

    @Autowired
    private BibleBookService bibleBookService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<BibleBook> bibleBooks = bibleBookService.getAllBibleBook();
        model.addAttribute("bibleBooks", bibleBooks);
        return "bibleBook/bibleBookList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addBibleBook(Model model) {
        model.addAttribute("bibleBook", new BibleBook());
        model.addAttribute("action", "create");
        return "bibleBook/bibleBookForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(BibleBook newBibleBook,
            RedirectAttributes redirectAttributes) {
        bibleBookService.saveBibleBook(newBibleBook);
        redirectAttributes.addFlashAttribute("message",
                "Create BibleBook Success!");
        return "redirect:/bibleBook/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("bibleBook", bibleBookService.getBibleBook(id));
        model.addAttribute("action", "update");
        return "bibleBook/bibleBookForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("bibleBook") BibleBook bibleBook) {
        bibleBookService.saveBibleBook(bibleBook);
        return "redirect:/bibleBook";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        bibleBookService.deleteBibleBook(id);
        redirectAttributes.addFlashAttribute("message",
                "Delete BibleBook Success!");
        return "redirect:/bibleBook";
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