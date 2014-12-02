package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.BibleBook;
import com.june.repository.BibleBookDao;

@Component
@Transactional
public class BibleBookService {
    private BibleBookDao bibleBookDao;

    public List<BibleBook> getAllBibleBook() {
        return (List<BibleBook>) bibleBookDao.findAll();
    }

    public BibleBook getBibleBook(Long id) {
        return bibleBookDao.findOne(id);
    }

    public BibleBook findByBibleBookTitle(String title) {
        return bibleBookDao.findByTitle(title);
    }

    public void saveBibleBook(BibleBook bibleBook) {
        bibleBookDao.save(bibleBook);
    }

    public void deleteBibleBook(Long id) {
        bibleBookDao.delete(id);

    }

    public void deleteBibleBook(BibleBook bibleBook) {
        bibleBookDao.delete(bibleBook);
    }

    @Autowired
    public void setBibleBookDao(BibleBookDao bibleBookDao) {
        this.bibleBookDao = bibleBookDao;
    }

}
