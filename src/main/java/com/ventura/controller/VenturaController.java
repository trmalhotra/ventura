package com.ventura.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ventura.model.Opportunity;
import com.ventura.model.Profile;
import com.ventura.service.VenturaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/ventura/")
@Api(value = "Opportunity Management")
public class VenturaController {

	@Autowired
	private VenturaService venturaService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	 
	@ApiOperation(value = "Add an Opportunity")
	@RequestMapping(method = RequestMethod.POST, value = "/opportunity/add")
	public ResponseEntity<String> addNewOpportunity(
			@ApiParam(value = "Opportunity object store in database table", required = true) @Valid @RequestBody Opportunity opportunity) {
		try {
			venturaService.addNewOpportunity(opportunity);
			log.info("Opportunity Role: " + opportunity.getPosition());
		} catch (Exception e) {
			return new ResponseEntity<String>("Opportunity was not added due to some internal issue",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Opportunity " + opportunity.getPosition() + " was added succesfully",
				HttpStatus.OK);
	}

	@ApiOperation(value = "Get all Opportunities", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved opportunities"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/opportunity/all", produces = "application/json")
	public ResponseEntity<List<Opportunity>> getAllOpportunities() {
		List<Opportunity> opportunityList = new ArrayList<Opportunity>();
		try {
			opportunityList = venturaService.getAllOpportunities();
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (opportunityList.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(opportunityList, HttpStatus.OK);
		}
	}
	
	
	@ApiOperation(value = "Add a Profile")
	@RequestMapping(method = RequestMethod.POST, value = "/profile/add")
	public ResponseEntity<Profile> addNewProfile(
			@ApiParam(value = "Profile object store in database table", required = true) @Valid @RequestBody Profile profile) {
		Profile profileAdded = null;
		try {
			profileAdded = venturaService.addNewProfile(profile);
			log.info("Profile created for Candidate: " + profileAdded.getFirstName());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (profileAdded == null || profileAdded.getFirstName() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(profileAdded, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Get all Profiles", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved profiles"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/profile/all", produces = "application/json")
	public ResponseEntity<List<Profile>> getAllProfiles() {
		List<Profile> profileList = new ArrayList<Profile>();
		try {
			profileList = venturaService.getAllProfiles();
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (profileList.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(profileList, HttpStatus.OK);
		}
	}

}
