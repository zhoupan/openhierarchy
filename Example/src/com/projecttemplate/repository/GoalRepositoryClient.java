package com.projecttemplate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projecttemplate.model.Goal;

public class GoalRepositoryClient {
	
	private GoalRepository repo;
	private AbstractApplicationContext context;
	
	public void initContext() {
		context = new ClassPathXmlApplicationContext("jpaContext.xml");
		repo = context.getBean(GoalRepository.class);
	}
	
	public void closeContext() {
		context.close();
	}
	
	public void createGoal(String type, int minutes) {
		 Goal g = new Goal(type, minutes);
		 repo.save(g);
    }
	
	public Goal findByType(String type)
	{
		Goal g = repo.findByType(type);
		return g;
	}
	

}
