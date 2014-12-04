package com.june.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.ActionPlan;
import com.june.entity.User;

public interface ActionPlanDao extends
        PagingAndSortingRepository<ActionPlan, Long> {
    ActionPlan findByTitle(String title);

    List<ActionPlan> findByUser(User user);
}
