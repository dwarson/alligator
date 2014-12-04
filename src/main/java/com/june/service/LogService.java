package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.Log;
import com.june.entity.User;
import com.june.repository.LogDao;

@Component
@Transactional
public class LogService {
    private LogDao logDao;

    public List<Log> getAllLog() {
        return (List<Log>) logDao.findAll();
    }

    public List<Log> getAllByUser(User user) {
        return (List<Log>) logDao.findByUser(user);
    }

    public Log getLog(Long id) {
        return logDao.findOne(id);
    }

    public Log findByLogTitle(String title) {
        return logDao.findByTitle(title);
    }

    public void saveLog(Log log) {
        logDao.save(log);
    }

    public void deleteLog(Long id) {
        logDao.delete(id);

    }

    public void deleteLog(Log log) {
        logDao.delete(log);
    }

    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

}
