package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.BibleChapter;

public interface BibleChapterDao extends PagingAndSortingRepository<BibleChapter, Long> {
    BibleChapter findByTitle(String title);
}
