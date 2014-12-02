package com.june.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "fs_thought")
public class Thought extends IdEntity {

	private String title;
	private Topic type;
	private String description;
	private User user;
	private Boolean actionable;
	private String outcome;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
    @ManyToOne
    @JoinColumn(name = "thought_type")
	public Topic getType() {
		return type;
	}

	public void setType(Topic type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Boolean getActionable() {
		return actionable;
	}

	public void setActionable(Boolean actionable) {
		this.actionable = actionable;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
