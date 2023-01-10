package com.sandbox.firsttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.firsttest.dto.AccountInformationDto;
import com.sandbox.firsttest.services.impl.TestServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	TestServiceImpl testServiceImpl;
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountInformationDto> index(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(testServiceImpl.getAccountInformation(id),null,HttpStatus.OK);
	}
}
