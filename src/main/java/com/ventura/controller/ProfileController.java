package com.ventura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ventura.model.Profile;
import com.ventura.service.ProfileService;

@RestController
@RequestMapping("/ventura/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/add", produces = "application/json")
	public Profile addNewProfile(Profile profile) {
		return profileService.addNewProfile(profile);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = "application/json")
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}
	

}
