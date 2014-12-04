package com.june.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.Thought;
import com.june.entity.User;

public interface ThoughtDao extends PagingAndSortingRepository<Thought, Long> {
    Thought findByTitle(String title);

    List<Thought> findByUser(User user);
}
