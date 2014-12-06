package com.june.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.Pray;
import com.june.entity.User;

public interface PrayDao extends PagingAndSortingRepository<Pray, Long> {
	Pray findByContent(String content);

	List<Pray> findByUser(User user);
}
