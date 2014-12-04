package com.june.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.Log;
import com.june.entity.User;

public interface LogDao extends PagingAndSortingRepository<Log, Long> {
    Log findByTitle(String title);

    List<Log> findByUser(User user);
}
