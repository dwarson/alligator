package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.Link;
import com.june.entity.User;
import com.june.repository.LinkDao;

@Component
@Transactional
public class LinkService {
    private LinkDao linkDao;

    public List<Link> getAllLink() {
        return (List<Link>) linkDao.findAll();
    }

    public List<Link> getAllByUser(User user) {
        return (List<Link>) linkDao.findByUser(user);
    }

    public Link getLink(Long id) {
        return linkDao.findOne(id);
    }

    public Link findByLinkTitle(String title) {
        return linkDao.findByTitle(title);
    }

    public void saveLink(Link link) {
        linkDao.save(link);
    }

    public void deleteLink(Long id) {
        linkDao.delete(id);

    }

    public void deleteLink(Link link) {
        linkDao.delete(link);
    }

    @Autowired
    public void setLinkDao(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

}
