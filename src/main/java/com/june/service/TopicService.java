package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.Topic;
import com.june.repository.TopicDao;

@Component
@Transactional
public class TopicService {
    private TopicDao topicDao;

    public List<Topic> getAllTopic() {
        return (List<Topic>) topicDao.findAll();
    }

    public Topic getTopic(Long id) {
        return topicDao.findOne(id);
    }

    public Topic findByTopicTitle(String title) {
        return topicDao.findByTitle(title);
    }

    public void saveTopic(Topic topic) {
        topicDao.save(topic);
    }

    public void deleteTopic(Long id) {
        topicDao.delete(id);

    }

    public void deleteTopic(Topic topic) {
        topicDao.delete(topic);
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

}
