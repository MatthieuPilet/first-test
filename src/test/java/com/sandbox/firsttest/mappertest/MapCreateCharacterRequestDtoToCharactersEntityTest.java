/**
 * 
 */
package com.sandbox.firsttest.mappertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.mapper.MapCreateCharacterRequestDtoToCharacterEntityImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@ContextConfiguration(classes = RunApplication.class)
@SpringBootTest
class MapCreateCharacterRequestDtoToCharactersEntityTest {

	@Autowired
	public MapCreateCharacterRequestDtoToCharacterEntityImpl mapCreateCharacterRequestDtoToCharactersEntity;
	
	@Test
	void mapTest() {
		CreateCharacterRequestDto createCharacterRequestDto = new CreateCharacterRequestDto(1,"TestName");	
		AccountInformationEntity aIEntity = new AccountInformationEntity();
		aIEntity.setAccountId(BigInteger.valueOf(1));
		CharacterEntity characterEntity = mapCreateCharacterRequestDtoToCharactersEntity.map(createCharacterRequestDto,aIEntity);
		
		assertNotNull(characterEntity);
		assertEquals(BigInteger.valueOf(1), characterEntity.getAccountInformationEntity().getAccountId());
		assertEquals("TestName", characterEntity.getCharacterName());		
	}
}
