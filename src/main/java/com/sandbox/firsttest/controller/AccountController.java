package com.sandbox.firsttest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.firsttest.dto.AccountInformationRequestDto;
import com.sandbox.firsttest.dto.AccountInformationResponseDto;
import com.sandbox.firsttest.services.impl.AccountServiceImpl;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountInformationResponseDto> getAccountInformation(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(accountServiceImpl.getAccountInformation(id),null,HttpStatus.OK);
	}
	
	@PutMapping("/createAccount")
	public ResponseEntity<AccountInformationResponseDto> createAccountInformation(@RequestBody @Valid AccountInformationRequestDto accountInformationDto) {
		return new ResponseEntity<>(accountServiceImpl.createAccountInformation(accountInformationDto),null,HttpStatus.OK);
	}
}
