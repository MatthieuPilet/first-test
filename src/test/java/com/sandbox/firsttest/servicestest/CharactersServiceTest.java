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
import com.sandbox.firsttest.mapper.MapCharacterEntityToCharacterResponseDto;
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
	MapCharacterEntityToCharacterResponseDto mapCharacterEntityToCharacterResponseDto;
	
	
	@Test
    void getAccountInformationOKTest() {
        Mockito.when(charactersRepositoryImpl.getCharacters(ArgumentMatchers.anyInt())).thenReturn(new ArrayList<>());
        Mockito.when(mapCharacterEntityToCharacterResponseDto.mapListToList(ArgumentMatchers.any())).thenReturn(new ArrayList<>());
        List<CharacterResponseDto> characters = charactersService.getCharacters(99999999);
        assertNotNull(characters);
    }
}
