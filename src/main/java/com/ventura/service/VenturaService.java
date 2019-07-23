package com.ventura.service;

import java.util.List;

import com.ventura.model.Opportunity;
import com.ventura.model.Profile;

public interface VenturaService {

	public Opportunity addNewOpportunity(Opportunity opportunity);
	
	public List<Opportunity> getAllOpportunities();
	
	public Profile addNewProfile(Profile profile);
	
	public List<Profile> getAllProfiles();

	
}
