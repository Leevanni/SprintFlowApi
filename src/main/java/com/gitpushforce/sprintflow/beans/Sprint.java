package com.gitpushforce.sprintflow.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@OneToMany(mappedBy = "sprint")
	@JsonManagedReference(value = "sprint-userstories")
	private List<Userstory> userstories;
	
	@Column(name = "SPRINT_SUMMARY")
	private String sprintSummary;
	
	@Column(name = "STATUS")
	private String status;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TIMESTAMP")
	private Date timeStamp;
	

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
		return userstories;
	}
	public void setUserStories(List<Userstory> userStories) {
		this.userstories = userStories;
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
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.endDate = dateCreated;
	}
	public Date getDateStarted() {
		return startDate;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	@Override
	public String toString() {
		return "Sprint [id=" + id + ", name=" + name + ", description=" + description + ", reviewDetails="
				+ reviewDetails + ", retroDetails=" + retroDetails + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", dateCreated=" + dateCreated + ", sprintSummary=" + sprintSummary
				+ ", status=" + status + ", timeStamp=" + timeStamp + "]";
	}
	
	
}
