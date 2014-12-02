package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.ActionPlan;
import com.june.repository.ActionPlanDao;

@Component
@Transactional
public class ActionPlanService {
	private ActionPlanDao ActionPlanDao;

	public List<ActionPlan> getAllActionPlan() {
		return (List<ActionPlan>) ActionPlanDao.findAll();
	}

	public ActionPlan getActionPlan(Long id) {
		return ActionPlanDao.findOne(id);
	}

	public ActionPlan findByActionPlanTitle(String title) {
		return ActionPlanDao.findByTitle(title);
	}

	public void saveActionPlan(ActionPlan ActionPlan) {
		ActionPlanDao.save(ActionPlan);
	}

	public void deleteActionPlan(Long id) {
		ActionPlanDao.delete(id);

	}

	public void deleteActionPlan(ActionPlan ActionPlan) {
		ActionPlanDao.delete(ActionPlan);
	}

	@Autowired
	public void setActionPlanDao(ActionPlanDao ActionPlanDao) {
		this.ActionPlanDao = ActionPlanDao;
	}

}
