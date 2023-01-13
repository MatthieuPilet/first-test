/**
 * 
 */
package com.sandbox.firsttest.mappertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.dto.AIResponseDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.mapper.MapAIEntityToAIResponseDto;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@ContextConfiguration(classes = RunApplication.class)
@SpringBootTest
class MapAIEntityToAIResponseDtoTest {

	@Autowired
	public MapAIEntityToAIResponseDto mapAIEntityToAIResponseDto;
	
	@Test
	void mapTest() {
		Date dateTest = Date.from(LocalDate.of(2023, 01, 12).atStartOfDay(ZoneId.systemDefault()).toInstant());
		AccountInformationEntity accountInformationEntity = new AccountInformationEntity();
		accountInformationEntity.setAccountAge(0);
		accountInformationEntity.setAccountBirthday(dateTest);
		accountInformationEntity.setAccountEmail("testMail");
		accountInformationEntity.setAccountId(BigInteger.valueOf(1));
		accountInformationEntity.setAccountPassword("testPassword");
		accountInformationEntity.setAccountSubscriptionDate(dateTest);
		accountInformationEntity.setAccountUsername("testUsername");
		AIResponseDto accountInformationResponseDto = mapAIEntityToAIResponseDto.map(accountInformationEntity);
		
		assertNotNull(accountInformationResponseDto);
		assertEquals(0, accountInformationResponseDto.getAccountAge());
		assertEquals(dateTest, accountInformationResponseDto.getAccountBirthday());
		assertEquals("testMail", accountInformationResponseDto.getAccountEmail());
		assertEquals(BigInteger.valueOf(1), accountInformationResponseDto.getAccountId());
		assertEquals("testPassword", accountInformationResponseDto.getAccountPassword());
		assertEquals(dateTest, accountInformationResponseDto.getAccountSubscriptionDate());
		assertEquals("testUsername", accountInformationResponseDto.getAccountUsername());
		
	}
	

}
