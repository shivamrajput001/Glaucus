package com.glaucus.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.glaucus.task.exception.RestServiceException;
import com.glaucus.task.service.NumberIncrementServiceImpl;

/**
 * A controller class responsible for handling of REST requests and response
 */
@RestController
public class GlaucusController {

	@Autowired
	NumberIncrementServiceImpl numberIncrementServiceImpl;

	@RequestMapping("/doIncrement")
	public @ResponseBody ResponseEntity<?> doIncrement() {
		try {
			
			numberIncrementServiceImpl.incrementNumber();
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (RestServiceException e) {
			e.printStackTrace();
			throw e;
		}
	}
}