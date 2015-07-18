package com.projecttemplate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Range;

@Entity
public class Goal {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String type;
	
	@Range(min=1, max=120, message="Number of minutes must be between 1 and 120")
	private int minutes;
	
	public Goal() {
		// Default constructor
	}

	public Goal(String type, int minutes) {
		setType(type);
		setMinutes(minutes);
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}