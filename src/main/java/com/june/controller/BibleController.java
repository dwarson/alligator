package com.june.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.june.entity.User;
import com.june.entity.UserChapterRecord;
import com.june.entity.UserChapterRecordPk;
import com.june.service.BibleBookService;
import com.june.service.BibleChapterService;
import com.june.service.UserChapterRecordService;
import com.june.service.UserService;

@Controller
@RequestMapping(value = "/bible")
public class BibleController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private BibleBookService bibleBookService;

    @Autowired
    private BibleChapterService bibleChapterService;

    @Autowired
    private UserChapterRecordService userChapterRecordService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        Map<Long, Boolean> records = new HashMap<Long, Boolean>();
        List<BibleBook> bibleBooks = bibleBookService.getAllBibleBook();
        User user = userService.getUser(getCurrentUserId());
        List<UserChapterRecord> userChapterRecords = userChapterRecordService
                .getAllUserChapterRecord();
        for (UserChapterRecord userChapterRecord : userChapterRecords) {
            if (user.getId().equals(userChapterRecord.getUser().getId())) {
                records.put(userChapterRecord.getBibleChapter().getId(), true);
            }
        }
        model.addAttribute("bibleBooks", bibleBooks);
        model.addAttribute("records", records);
        return "bible/bibleList";
    }
    //TODO:refactor
    @RequestMapping(value = "read/{id}", method = RequestMethod.GET)
    public String readBook(@PathVariable("id") Long id, Model model) {
        String notes="";
        User user = userService.getUser(getCurrentUserId());
        BibleChapter bibleChapter = bibleChapterService.getBibleChapter(id);
        UserChapterRecordPk pk = new UserChapterRecordPk();
        pk.setBibleChapter(bibleChapter);
        pk.setUser(user);
        UserChapterRecord userChapterRecord = userChapterRecordService.getByPk(pk);
        if(userChapterRecord != null){
            notes = userChapterRecord.getNotes();
        }
        List<BibleBook> books = bibleBookService.getAllBibleBook();
        model.addAttribute("books", books);
        model.addAttribute("bibleChapter",bibleChapter);
        model.addAttribute("notes",notes);
        model.addAttribute("action", "read");
        return "bibleChapter/bibleChapterForm";
    }

    @RequestMapping(value = "read", method = RequestMethod.POST)
    public String readBook(@RequestParam("notes") String notes,
            @Valid @ModelAttribute("bibleChapter") BibleChapter bibleChapter) {
        User user = userService.getUser(getCurrentUserId());
        UserChapterRecordPk pk = new UserChapterRecordPk();
        pk.setBibleChapter(bibleChapter);
        pk.setUser(user);
        UserChapterRecord userChapterRecord = userChapterRecordService.getByPk(pk);
        if(userChapterRecord == null){
            userChapterRecord = new UserChapterRecord();
            userChapterRecord.setBibleChapter(bibleChapter);
            userChapterRecord.setUser(user);
            userChapterRecord.setStatus(1);
        }else{
            userChapterRecord.setStatus(userChapterRecord.getStatus() + 1);
        }
        userChapterRecord.setNotes(notes);
        userChapterRecordService.saveUserChapterRecord(userChapterRecord);
        return "redirect:/bible";
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