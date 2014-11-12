package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.User;
import com.june.repository.UserDao;

@Component
@Transactional
public class UserService {
    private UserDao userDao;

    public List<User> getAllUser() {
        return (List<User>) userDao.findAll();
    }

    public User getUser(Long id) {
        return userDao.findOne(id);
    }

    public User findUserByLoginName(String username) {
        return userDao.findByUsername(username);
    }

    public void registerUser(User user) {
        userDao.save(user);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
