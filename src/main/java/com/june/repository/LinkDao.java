package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.Link;

public interface LinkDao extends PagingAndSortingRepository<Link, Long> {
    Link findByTitle(String title);
}
