package com.sandbox.firsttest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.firsttest.dto.AIRequestDto;
import com.sandbox.firsttest.dto.AIResponseDto;
import com.sandbox.firsttest.dto.UpdateAIRequestDto;
import com.sandbox.firsttest.services.impl.AccountServiceImpl;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@GetMapping("/{id}")
	public ResponseEntity<AIResponseDto> getAccountInformation(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(accountServiceImpl.getAccountInformation(id),null,HttpStatus.OK);
	}
	
	@PutMapping("/createAccount")
	public ResponseEntity<AIResponseDto> createAccountInformation(@RequestBody @Valid AIRequestDto accountInformationDto) {
		return new ResponseEntity<>(accountServiceImpl.createAccountInformation(accountInformationDto),null,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccountInformation(@PathVariable("id") Integer id) {
		try {
			accountServiceImpl.deleteAccountInformation(id);
			return new ResponseEntity<>("L'objet a été delete",null,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("L'objet n'a pas été delete",null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/updateAccount")
	public ResponseEntity<AIResponseDto> updateAccountInformation(@RequestBody @Valid UpdateAIRequestDto updateAIRequestDto) {
		return new ResponseEntity<>(accountServiceImpl.updateAccountInformation(updateAIRequestDto),null,HttpStatus.OK);
	}
}
