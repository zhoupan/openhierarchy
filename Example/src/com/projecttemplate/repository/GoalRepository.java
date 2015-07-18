package com.projecttemplate.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.projecttemplate.model.Goal;

@Transactional
public interface GoalRepository extends CrudRepository<Goal, Long> {
	
	// No implementation needed. The JPA will do this for you!
	public Goal findByType(String type);
}
