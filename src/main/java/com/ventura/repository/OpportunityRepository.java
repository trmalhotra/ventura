package com.ventura.repository;

import java.util.List;

import com.ventura.model.Opportunity;

public interface OpportunityRepository {
	
	public Opportunity addNewOpportunity(Opportunity opportunity);
	
	public List<Opportunity> getAllOpportunities();

}
