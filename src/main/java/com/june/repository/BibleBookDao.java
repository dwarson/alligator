package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.BibleBook;

public interface BibleBookDao extends PagingAndSortingRepository<BibleBook, Long> {
    BibleBook findByTitle(String title);
}
