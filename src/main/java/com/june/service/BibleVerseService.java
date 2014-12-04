package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.BibleVerse;
import com.june.repository.BibleVerseDao;

@Component
@Transactional
public class BibleVerseService {
    private BibleVerseDao bibleVerseDao;

    public List<BibleVerse> getAllBibleVerse() {
        return (List<BibleVerse>) bibleVerseDao.findAll();
    }

    public BibleVerse getBibleVerse(Long id) {
        return bibleVerseDao.findOne(id);
    }

    public BibleVerse findByBibleVerseTitle(String title) {
        return bibleVerseDao.findByTitle(title);
    }

    public void saveBibleVerse(BibleVerse bibleVerse) {
        bibleVerseDao.save(bibleVerse);
    }

    public void deleteBibleVerse(Long id) {
        bibleVerseDao.delete(id);

    }

    public void deleteBibleVerse(BibleVerse bibleVerse) {
        bibleVerseDao.delete(bibleVerse);
    }

    @Autowired
    public void setBibleVerseDao(BibleVerseDao bibleVerseDao) {
        this.bibleVerseDao = bibleVerseDao;
    }

}
