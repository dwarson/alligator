package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.Pray;
import com.june.entity.User;
import com.june.repository.PrayDao;

@Component
@Transactional
public class PrayService {
	private PrayDao prayDao;

	public List<Pray> getAllPray() {
		return (List<Pray>) prayDao.findAll();
	}

	public List<Pray> getAllByUser(User user) {
		return (List<Pray>) prayDao.findByUser(user);
	}

	public Pray getPray(Long id) {
		return prayDao.findOne(id);
	}

	public Pray findByContent(String content) {
		return prayDao.findByContent(content);
	}

	public void savePray(Pray pray) {
		prayDao.save(pray);
	}

	public void deletePray(Long id) {
		prayDao.delete(id);

	}

	public void deletePray(Pray pray) {
		prayDao.delete(pray);
	}

	@Autowired
	public void setPrayDao(PrayDao prayDao) {
		this.prayDao = prayDao;
	}

}
