package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.Log;

public interface LogDao extends PagingAndSortingRepository<Log, Long> {
	Log findByTitle(String title);
}
