package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.UserChapterRecord;
import com.june.entity.UserChapterRecordPk;
import com.june.repository.UserChapterRecordDao;

@Component
@Transactional
public class UserChapterRecordService {
    private UserChapterRecordDao userChapterRecordDao;

    public List<UserChapterRecord> getAllUserChapterRecord() {
        return (List<UserChapterRecord>) userChapterRecordDao.findAll();
    }

    public UserChapterRecord getByPk(UserChapterRecordPk pk) {
        return userChapterRecordDao.findByPk(pk);
    }

    public void saveUserChapterRecord(UserChapterRecord userChapterRecord) {
        userChapterRecordDao.save(userChapterRecord);
    }

    public void deleteUserChapterRecord(Long id) {
        userChapterRecordDao.delete(id);

    }

    public void deleteUserChapterRecord(UserChapterRecord userChapterRecord) {
        userChapterRecordDao.delete(userChapterRecord);
    }

    @Autowired
    public void setUserChapterRecordDao(UserChapterRecordDao userChapterRecord) {
        this.userChapterRecordDao = userChapterRecord;
    }

}
