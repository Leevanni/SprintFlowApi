package com.gitpushforce.sprintflow.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "COMMENT")
public class Comment {
	
	@Id
	@Column(name = "COMMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERSTORY_ID")
	@JsonBackReference(value = "userstory-comments")
	private Userstory userStory;
	
	public Comment() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@JsonIgnore
	public Userstory getUserStoryId() {
		return userStory;
	}
	
	public void setUserStoryId(Userstory userstory) {
		this.userStory = userstory;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", userStoryId=" + userStory + "]";
	}
}
