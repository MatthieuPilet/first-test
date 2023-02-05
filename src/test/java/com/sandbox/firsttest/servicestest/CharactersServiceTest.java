/**
 * 
 */
package com.sandbox.firsttest.servicestest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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
import com.sandbox.firsttest.dto.UpdateWeaponCharacterRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.mapper.MapCharacterEntityToCharacterResponseDto;
import com.sandbox.firsttest.mapper.MapCreateCharacterRequestDtoToCharacterEntity;
import com.sandbox.firsttest.repository.impl.AccountRepositoryImpl;
import com.sandbox.firsttest.repository.impl.BaseWeaponRepositoryImpl;
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
	BaseWeaponRepositoryImpl baseWeaponRepositoryImpl;
	
	@Mock
	MapCharacterEntityToCharacterResponseDto mapCharacterEntityToCharacterResponseDto;
	
	@Mock
	MapCreateCharacterRequestDtoToCharacterEntity mapCreateCharacterRequestDtoToCharacterEntity;
	
	@BeforeEach
	void testInit() {
		Mockito.when(charactersRepositoryImpl.getCharacters(ArgumentMatchers.any())).thenReturn(new ArrayList<>());
		Mockito.when(charactersRepositoryImpl.getCharacter(ArgumentMatchers.any())).thenReturn(new CharacterEntity());
		Mockito.when(charactersRepositoryImpl.updateWeaponCharacter(ArgumentMatchers.any())).thenReturn(new CharacterEntity());
		Mockito.when(charactersRepositoryImpl.createCharacter(ArgumentMatchers.any())).thenReturn(new CharacterEntity());
        	
		Mockito.when(accountRepositoryImpl.getAccountInformation(ArgumentMatchers.any())).thenReturn(new AccountInformationEntity());
		
		Mockito.when(baseWeaponRepositoryImpl.getBaseWeapon(ArgumentMatchers.any())).thenReturn(new BaseWeaponEntity());

		Mockito.when(mapCharacterEntityToCharacterResponseDto.mapListToList(ArgumentMatchers.any())).thenReturn(new ArrayList<>());
        Mockito.when(mapCharacterEntityToCharacterResponseDto.map(ArgumentMatchers.any())).thenReturn(new CharacterResponseDto());
        
        Mockito.when(mapCreateCharacterRequestDtoToCharacterEntity.map(ArgumentMatchers.any(),ArgumentMatchers.any())).thenReturn(new CharacterEntity());
	}
	
	@Test
	@Order(1)
    void getCharactersOKTest() {
        List<CharacterResponseDto> characters = charactersService.getCharacters(99999999);
        assertNotNull(characters);
    }
	
	@Test
	@Order(2)
    void getCharacterOKTest() {
        CharacterResponseDto character = charactersService.getCharacter(99999999);
        assertNotNull(character);
    }
	
	@Test
	@Order(3)
    void createCharacterOKTest() {
		CharacterResponseDto characterResponseDto = charactersService.createCharacter(new CreateCharacterRequestDto());
        assertNotNull(characterResponseDto);
    }
	
	@Test
	@Order(4)
	void updateWeaponCharacterOKTest() {
		CharacterResponseDto characterResponseDto = charactersService.updateWeaponCharacter(new UpdateWeaponCharacterRequestDto());
		assertNotNull(characterResponseDto);
	}
}
