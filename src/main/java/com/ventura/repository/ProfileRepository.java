package com.ventura.repository;

import java.util.List;

import com.ventura.model.Profile;

public interface ProfileRepository {

	public Profile addNewProfile(Profile profile);
	
	public List<Profile> getAllProfiles();
}
