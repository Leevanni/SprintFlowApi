package com.gitpushforce.sprintflow.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gitpushforce.sprintflow.beans.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
