package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.BibleChapter;
import com.june.repository.BibleChapterDao;

@Component
@Transactional
public class BibleChapterService {
    private BibleChapterDao bibleChapterDao;

    public List<BibleChapter> getAllBibleChapter() {
        return (List<BibleChapter>) bibleChapterDao.findAll();
    }

    public BibleChapter getBibleChapter(Long id) {
        return bibleChapterDao.findOne(id);
    }

    public BibleChapter findByBibleChapterTitle(String title) {
        return bibleChapterDao.findByTitle(title);
    }

    public void saveBibleChapter(BibleChapter bibleChapter) {
        bibleChapterDao.save(bibleChapter);
    }

    public void deleteBibleChapter(Long id) {
        bibleChapterDao.delete(id);

    }

    public void deleteBibleChapter(BibleChapter bibleChapter) {
        bibleChapterDao.delete(bibleChapter);
    }

    @Autowired
    public void setBibleChapterDao(BibleChapterDao bibleChapterDao) {
        this.bibleChapterDao = bibleChapterDao;
    }

}
