package com.june.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.Link;
import com.june.entity.User;

public interface LinkDao extends PagingAndSortingRepository<Link, Long> {
    Link findByTitle(String title);

    List<Link> findByUser(User user);
}
