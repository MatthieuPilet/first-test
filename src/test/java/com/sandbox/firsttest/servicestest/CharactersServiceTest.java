/**
 * 
 */
package com.sandbox.firsttest.servicestest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.mapper.MapCharacterEntityToCharacterResponseDto;
import com.sandbox.firsttest.mapper.MapCreateCharacterRequestDtoToCharacterEntity;
import com.sandbox.firsttest.repository.impl.AccountRepositoryImpl;
import com.sandbox.firsttest.repository.impl.CharactersRepositoryImpl;
import com.sandbox.firsttest.services.impl.CharactersServiceImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@ContextConfiguration(classes = RunApplication.class)
class CharactersServiceTest {
	@InjectMocks
	CharactersServiceImpl charactersService;
	
	@Mock
	CharactersRepositoryImpl charactersRepositoryImpl;
	
	@Mock
	AccountRepositoryImpl accountRepositoryImpl;
	
	@Mock
	MapCharacterEntityToCharacterResponseDto mapCharacterEntityToCharacterResponseDto;
	
	@Mock
	MapCreateCharacterRequestDtoToCharacterEntity mapCreateCharacterRequestDtoToCharacterEntity;
	
	
	@Test
    void getCharactersOKTest() {
        Mockito.when(charactersRepositoryImpl.getCharacters(ArgumentMatchers.anyInt())).thenReturn(new ArrayList<>());
        Mockito.when(mapCharacterEntityToCharacterResponseDto.mapListToList(ArgumentMatchers.any())).thenReturn(new ArrayList<>());
        List<CharacterResponseDto> characters = charactersService.getCharacters(99999999);
        assertNotNull(characters);
    }
	
	@Test
    void createCharacterOKTest() {
		Mockito.when(accountRepositoryImpl.getAccountInformation(ArgumentMatchers.any())).thenReturn(new AccountInformationEntity());
        Mockito.when(charactersRepositoryImpl.createCharacter(ArgumentMatchers.any())).thenReturn(new CharacterEntity());
        Mockito.when(mapCharacterEntityToCharacterResponseDto.map(ArgumentMatchers.any())).thenReturn(new CharacterResponseDto());
        Mockito.when(mapCreateCharacterRequestDtoToCharacterEntity.map(ArgumentMatchers.any(),ArgumentMatchers.any())).thenReturn(new CharacterEntity());
        CharacterResponseDto characterResponseDto = charactersService.createCharacter(new CreateCharacterRequestDto());
        assertNotNull(characterResponseDto);
    }
}
