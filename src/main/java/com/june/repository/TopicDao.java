package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.Topic;

public interface TopicDao extends PagingAndSortingRepository<Topic, Long> {
    Topic findByTitle(String title);
}
