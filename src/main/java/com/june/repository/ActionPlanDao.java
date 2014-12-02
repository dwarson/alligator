package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.ActionPlan;

public interface ActionPlanDao extends PagingAndSortingRepository<ActionPlan, Long> {
	ActionPlan findByTitle(String title);
}
