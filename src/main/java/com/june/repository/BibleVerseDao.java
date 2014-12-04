package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.BibleVerse;

public interface BibleVerseDao extends PagingAndSortingRepository<BibleVerse, Long> {
    BibleVerse findByTitle(String title);
}