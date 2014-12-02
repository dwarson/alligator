package com.june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.june.entity.Thought;
import com.june.repository.ThoughtDao;

@Component
@Transactional
public class ThoughtService {
	private ThoughtDao thoughtDao;

	public List<Thought> getAllThought() {
		return (List<Thought>) thoughtDao.findAll();
	}

	public Thought getThought(Long id) {
		return thoughtDao.findOne(id);
	}

	public Thought findByThoughtTitle(String title) {
		return thoughtDao.findByTitle(title);
	}

	public void saveThought(Thought thought) {
		thoughtDao.save(thought);
	}

	public void deleteThought(Long id) {
		thoughtDao.delete(id);

	}

	public void deleteThought(Thought thought) {
		thoughtDao.delete(thought);
	}

	@Autowired
	public void setThoughtDao(ThoughtDao thoughtDao) {
		this.thoughtDao = thoughtDao;
	}

}
