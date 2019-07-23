package com.ventura.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ventura.model.Opportunity;
import com.ventura.model.Profile;

@Service
@PropertySource(value = "classpath:application.properties")
public class VenturaServiceImpl implements VenturaService {

	@Autowired
	private RestTemplate restTemplate;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Value("${opportunity.service.url}")
	private String opportunityServiceUrl;

	@Autowired
	@Value("${profile.service.url}")
	private String profileServiceUrl;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

	public Opportunity addNewOpportunity(Opportunity opportunity) {

		String url = opportunityServiceUrl + "/add";

		log.info("Add an opportunity URL: " + url);

		return restTemplate.postForObject(url, opportunity, Opportunity.class);
	}

	public List<Opportunity> getAllOpportunities() {

		String url = opportunityServiceUrl + "/all";

		log.info("Get all opportunities URL: " + url);

		ResponseEntity<List<Opportunity>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Opportunity>>() {
				});

		return response.getBody();
	}

	@Override
	public Profile addNewProfile(Profile profile) {
		String url = profileServiceUrl + "/add";

		log.info("Add a Profile URL: " + url);

		return restTemplate.postForObject(url, profile, Profile.class);
	}

	@Override
	public List<Profile> getAllProfiles() {
		String url = profileServiceUrl + "/all";

		log.info("Get all profiles URL: " + url);

		ResponseEntity<List<Profile>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Profile>>() {
				});

		return response.getBody();
	}
	
	
	

}
