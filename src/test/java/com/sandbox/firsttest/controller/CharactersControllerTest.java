/**
 * 
 */
package com.sandbox.firsttest.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.services.impl.CharactersServiceImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
class CharactersControllerTest {

	@InjectMocks
	CharactersController charactersController;
	
	@Mock
	CharactersServiceImpl charactersService;
	
	
	@Test
    void getCharactersOKTest() {
		Mockito.when(charactersService.getCharacters(ArgumentMatchers.anyInt())).thenReturn(new ArrayList<>());
		ResponseEntity<List<CharacterResponseDto>> characters = charactersController.getCharacters(ArgumentMatchers.any());
        assertNotNull(characters);
    }
	
	@Test
    void createCharacterOKTest() {
		Mockito.when(charactersService.createCharacter(ArgumentMatchers.any())).thenReturn(new CharacterResponseDto());
		ResponseEntity<CharacterResponseDto> characters = charactersController.createCharacter(ArgumentMatchers.any());
        assertNotNull(characters);
    }
}
