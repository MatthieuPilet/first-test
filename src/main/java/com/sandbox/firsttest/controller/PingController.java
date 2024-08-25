package com.sandbox.firsttest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller is for all operation about AccountInformation
 * 
 * @author Matthieu P
 * @version 1.0
 */
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/ping")
public class PingController {
	
	
	/**
	 * This method is to ping the API
	 * 
	 * @return String to say OK
	 */
	@GetMapping("")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("Ping OK",null,HttpStatus.OK);
	}
}
