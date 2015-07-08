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
	
	@Range(min=1, max=120, message="Antal minuter måste vara mellan 1 och 120")
	private int minutes;

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}