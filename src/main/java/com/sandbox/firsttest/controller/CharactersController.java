package com.sandbox.firsttest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.dto.UpdateWeaponCharacterRequestDto;
import com.sandbox.firsttest.services.impl.CharactersServiceImpl;

/**
 * This controller is about all operation of Characters
 * 
 * @author Matthieu P
 * @version 1.0
 */
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/characters")
public class CharactersController {
	
	@Autowired
	CharactersServiceImpl charactersServiceImpl;
	
	/**
	 * This method is to get a list of character by account id
	 * 
	 * @param accountId the id of the account
	 * @return List<{@link CharacterResponseDto}>
	 */
	@GetMapping("/{id}")
	public ResponseEntity<List<CharacterResponseDto>> getCharacters(@PathVariable("id") Integer accountId) {
		return new ResponseEntity<>(charactersServiceImpl.getCharacters(accountId),null,HttpStatus.OK);
	}
	
	/**
	 * This method is to get a character by id
	 * 
	 * @param characterId the id of the character
	 * @return {@link CharacterResponseDto}
	 */
	@GetMapping("character/{id}")
	public ResponseEntity<CharacterResponseDto> getCharacter(@PathVariable("id") Integer characterId) {
		return new ResponseEntity<>(charactersServiceImpl.getCharacter(characterId),null,HttpStatus.OK);
	}
	
	/**
	 * This method is to create character by put operation
	 * 
	 * @param createCharacterRequestDto {@link CreateCharacterRequestDto}
	 * @return {@link CharacterResponseDto}
	 */
	@PutMapping("/createCharacter")
	public ResponseEntity<CharacterResponseDto> createCharacter(@RequestBody CreateCharacterRequestDto createCharacterRequestDto) {
		return new ResponseEntity<>(charactersServiceImpl.createCharacter(createCharacterRequestDto),null,HttpStatus.OK);
	}

	/**
	 * This method is to update a character
	 * 
	 * @param updateWeaponCharacterRequestDto {@link UpdateWeaponCharacterRequestDto}
	 * @return {@link CharacterResponseDto}
	 */
	@PostMapping("/updateWeaponCharacter")
	public ResponseEntity<CharacterResponseDto> updateWeaponCharacter(@RequestBody UpdateWeaponCharacterRequestDto updateWeaponCharacterRequestDto) {
		return new ResponseEntity<>(charactersServiceImpl.updateWeaponCharacter(updateWeaponCharacterRequestDto),null,HttpStatus.OK);
	}
}
