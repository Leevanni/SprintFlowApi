package com.gitpushforce.sprintflow.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // Tells Spring that this class is a controller
@RequestMapping("api")
public class SprintController implements InitializingBean {
	
	private static final Logger log = Logger.getLogger(SprintController.class);
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
