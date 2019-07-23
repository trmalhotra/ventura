package com.ventura.opportunity.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "opportunity")
public class Opportunity {

	@Id
	private String id;
	private Date dateCreated;
	private String ltiPoc;
	private String team;
	private List<String> interviewPanel;
	private String role;
	private Integer numberOfPositions;

	public Opportunity() {
	}

	public Opportunity(Date dateCreated, String ltiPoc, String team, List<String> interviewPanel,
			String role, Integer numberOfPositions) {
		super();
		this.dateCreated = dateCreated;
		this.ltiPoc = ltiPoc;
		this.team = team;
		this.interviewPanel = interviewPanel;
		this.role = role;
		this.numberOfPositions = numberOfPositions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLtiPoc() {
		return ltiPoc;
	}

	public void setLtiPoc(String ltiPoc) {
		this.ltiPoc = ltiPoc;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public List<String> getInterviewPanel() {
		return interviewPanel;
	}

	public void setInterviewPanel(List<String> interviewPanel) {
		this.interviewPanel = interviewPanel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getNumberOfPositions() {
		return numberOfPositions;
	}

	public void setNumberOfPositions(Integer numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}

	public String toString() {
		return String.format(
				"Oportunity [id=%s, Date Created=%s, LTI POC=%s, Team=%s, Interview Panel=%s, Role=%s, Number of Positions=%s]",
				id, dateCreated, ltiPoc, team, interviewPanel, role, numberOfPositions);
	}

}
