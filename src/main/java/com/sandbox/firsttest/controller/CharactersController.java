package com.sandbox.firsttest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.services.impl.CharactersServiceImpl;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/characters")
public class CharactersController {
	
	@Autowired
	CharactersServiceImpl charactersServiceImpl;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<CharacterResponseDto>> getCharacters(@PathVariable("id") Integer accountId) {
		return new ResponseEntity<>(charactersServiceImpl.getCharacters(accountId),null,HttpStatus.OK);
	}
	
	@PutMapping("/createCharacter")
	public ResponseEntity<CharacterResponseDto> createCharacter(CreateCharacterRequestDto createCharacterRequestDto) {
		return new ResponseEntity<>(charactersServiceImpl.createCharacter(createCharacterRequestDto),null,HttpStatus.OK);
	}

}
