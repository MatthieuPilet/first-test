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
import com.sandbox.firsttest.dto.UpdateAIRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.mapper.MapUpdateAIRequestDtoToAIEntityImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@ContextConfiguration(classes = RunApplication.class)
@SpringBootTest
class MapUpdateAIRequestDtoToAIEntityTest {

	@Autowired
	public MapUpdateAIRequestDtoToAIEntityImpl mapUpdateAIRequestDtoToAIEntity;
	
	@Test
	void mapTest() {
		UpdateAIRequestDto updateAIRequestDto = new UpdateAIRequestDto();
		updateAIRequestDto.setAccountEmail("testMail");
		updateAIRequestDto.setAccountPassword("testPassword");
		updateAIRequestDto.setAccountUsername("testUsername");
		updateAIRequestDto.setAccountId(BigInteger.valueOf(10));
		AccountInformationEntity accountInformationEntity = mapUpdateAIRequestDtoToAIEntity.map(updateAIRequestDto);
		
		assertNotNull(accountInformationEntity);
		assertEquals("testMail", accountInformationEntity.getAccountEmail());
		assertEquals("testPassword", accountInformationEntity.getAccountPassword());
		assertEquals("testUsername", accountInformationEntity.getAccountUsername());
		assertEquals(BigInteger.valueOf(10), accountInformationEntity.getAccountId());
		
	}
}
