package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.Thought;

public interface ThoughtDao extends PagingAndSortingRepository<Thought, Long> {
	Thought findByTitle(String title);
}
