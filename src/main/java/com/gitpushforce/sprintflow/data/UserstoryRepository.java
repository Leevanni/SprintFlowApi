package com.gitpushforce.sprintflow.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gitpushforce.sprintflow.beans.Userstory;

@Repository
public interface UserstoryRepository extends JpaRepository<Userstory, Integer>{

}
