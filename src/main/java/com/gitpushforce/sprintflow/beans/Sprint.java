package com.gitpushforce.sprintflow.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "SPRINT")
public class Sprint {
	
	@Id
	@Column(name = "SPRINT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "REVIEW_DETAILS")
	private String reviewDetails;
	
	@Column(name = "RETRO_DETAILS")
	private String retroDetails;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;
	
	@OneToMany(mappedBy = "sprint")
	@JsonManagedReference(value = "sprint-userstory")
	private List<Userstory> userStories;
	
	@Column(name = "SPRINT_SUMMARY")
	private String sprintSummary;
	
	@Column(name = "STATUS")
	private String status;
	
	public Sprint() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReviewDetails() {
		return reviewDetails;
	}
	public void setReviewDetails(String reviewDetails) {
		this.reviewDetails = reviewDetails;
	}
	public String getRetroDetails() {
		return retroDetails;
	}
	public void setRetroDetails(String retroDetails) {
		this.retroDetails = retroDetails;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Userstory> getUserStories() {
		return userStories;
	}
	public void setUserStories(List<Userstory> userStories) {
		this.userStories = userStories;
	}
	public String getSprintSummary() {
		return sprintSummary;
	}
	public void setSprintSummary(String sprintSummary) {
		this.sprintSummary = sprintSummary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Sprint [id=" + id + ", name=" + name + ", description=" + description + ", reviewDetails="
				+ reviewDetails + ", retroDetails=" + retroDetails + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", sprintSummary=" + sprintSummary + ", status=" + status + "]";
	}
}
