package com.ventura.service;

import java.util.List;

import com.ventura.model.Opportunity;

public interface OpportunityService {

	public Opportunity addNewOpportunity(Opportunity opportunity);
	
	public List<Opportunity> getAllOpportunities();
	
}
