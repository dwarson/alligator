package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
