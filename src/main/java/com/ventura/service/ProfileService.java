package com.ventura.service;

import java.util.List;

import com.ventura.model.Profile;

public interface ProfileService {
	
	public Profile addNewProfile(Profile profile);
	
	public List<Profile> getAllProfiles();

}
