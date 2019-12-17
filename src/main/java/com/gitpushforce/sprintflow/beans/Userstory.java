package com.gitpushforce.sprintflow.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name = "USERSTORY")
public class Userstory {
	
	@Id
	@Column(name="USERSTORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "SUMMARY")
	private String summary;
	
	@Column(name = "PRIORITY")
	private String priority;
	
	@OneToMany(mappedBy = "userStory")
	@JsonManagedReference(value = "userstory-comments")
	private List<Comment> comments;
	
	@Column(name = "STORYPOINT")
	private int storyPoint;
	
	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPRINT_ID")
	@JsonBackReference(value = "sprint-userstory")
	private Sprint sprint;
	
	public Userstory() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getStoryPoint() {
		return storyPoint;
	}

	public void setStoryPoint(int storyPoint) {
		this.storyPoint = storyPoint;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Userstory [id=" + id + ", title=" + title + ", description=" + description + ", summary=" + summary
				+ ", priority=" + priority + ", storyPoint=" + storyPoint + ", status=" + status + ", sprintId="
				+ sprint + "]";
	}

	public Sprint getSprintId() {
		return sprint;
	}

	public void setSprintId(Sprint sprint) {
		this.sprint = sprint;
	}
}
