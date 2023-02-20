/**
 * 
 */
package com.sandbox.firsttest.mappertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.mapper.MapCharacterEntityToCharacterResponseDtoImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@ContextConfiguration(classes = RunApplication.class)
@SpringBootTest
class MapCharactersEntityToCharactersResponseDtoTest {

	@Autowired
	public MapCharacterEntityToCharacterResponseDtoImpl mapCharacterEntityToCharacterResponseDto;
	
	@Test
	void mapTest() {
		CharacterEntity characterEntity = new CharacterEntity(1,1,1,1,"testUsername","testTitle");		
		CharacterResponseDto characterResponseDto = mapCharacterEntityToCharacterResponseDto.map(characterEntity);
		
		assertNotNull(characterResponseDto);
		assertEquals(BigInteger.valueOf(1), characterResponseDto.getAccountId());
		assertEquals(BigInteger.valueOf(1), characterResponseDto.getBaseWeaponId());
		assertEquals(BigInteger.valueOf(1), characterResponseDto.getCharacterId());
		assertEquals(BigInteger.valueOf(1), characterResponseDto.getCharacterStatsId());
		assertEquals("testTitle", characterResponseDto.getCharacterTitle());
		assertEquals("testUsername", characterResponseDto.getCharacterName());
		
	}
	
	@Test
	void mapListToListTest() {
		List<CharacterEntity> characters = new ArrayList<>();
		characters.add(new CharacterEntity(1,1,1,1,"testUsername","testTitle"));
		characters.add(new CharacterEntity(2,1,1,2,"testUsername2","testTitle2"));
		characters.add(new CharacterEntity(3,1,1,3,"testUsername3","testTitle3"));

		List<CharacterResponseDto> charactersResponse = mapCharacterEntityToCharacterResponseDto.mapListToList(characters);
		assertEquals(3, charactersResponse.size());
		assertEquals(BigInteger.valueOf(1), charactersResponse.get(0).getCharacterId());
		assertEquals(BigInteger.valueOf(2), charactersResponse.get(1).getCharacterId());
		assertEquals(BigInteger.valueOf(3), charactersResponse.get(2).getCharacterId());
		
	}

}
