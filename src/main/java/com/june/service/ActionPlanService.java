package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.ActionPlan;
import com.june.entity.User;
import com.june.repository.ActionPlanDao;

@Component
@Transactional
public class ActionPlanService {
    private ActionPlanDao actionPlanDao;

    public List<ActionPlan> getAllActionPlan() {
        return (List<ActionPlan>) actionPlanDao.findAll();
    }

    public List<ActionPlan> getAllByUser(User user) {
        return (List<ActionPlan>) actionPlanDao.findByUser(user);
    }

    public ActionPlan getActionPlan(Long id) {
        return actionPlanDao.findOne(id);
    }

    public ActionPlan findByActionPlanTitle(String title) {
        return actionPlanDao.findByTitle(title);
    }

    public void saveActionPlan(ActionPlan actionPlan) {
        actionPlanDao.save(actionPlan);
    }

    public void deleteActionPlan(Long id) {
        actionPlanDao.delete(id);

    }

    public void deleteActionPlan(ActionPlan actionPlan) {
        actionPlanDao.delete(actionPlan);
    }

    @Autowired
    public void setActionPlanDao(ActionPlanDao actionPlan) {
        this.actionPlanDao = actionPlan;
    }

}
