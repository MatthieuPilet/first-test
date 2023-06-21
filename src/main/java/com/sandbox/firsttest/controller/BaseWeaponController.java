package com.sandbox.firsttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.firsttest.dto.BWResponseDto;
import com.sandbox.firsttest.services.impl.BaseWeaponServiceImpl;

/**
 * This controller is for all operation about AccountInformation
 * 
 * @author Matthieu P
 * @version 1.0
 */
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/base_weapon")
public class BaseWeaponController {
	
	@Autowired
	BaseWeaponServiceImpl baseWeaponServiceImpl;
	
	/**
	 * This method is to get base weapon by id
	 * 
	 * @param id the id of the weapon 
	 * @return {@link BWResponseDto}
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BWResponseDto> getBaseWeapon(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(baseWeaponServiceImpl.getBaseWeapon(id),null,HttpStatus.OK);
	}
}
