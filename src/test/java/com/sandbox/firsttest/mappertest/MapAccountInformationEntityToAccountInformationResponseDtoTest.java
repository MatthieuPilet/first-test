/**
 * 
 */
package com.sandbox.firsttest.mappertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.dto.AccountInformationResponseDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.mapper.MapAccountInformationEntityToAccountInformationResponseDto;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@ContextConfiguration(classes = RunApplication.class)
@SpringBootTest
class MapAccountInformationEntityToAccountInformationResponseDtoTest {

	@Autowired
	public MapAccountInformationEntityToAccountInformationResponseDto mapAccountInformationEntityToAccountInformationResponseDto;
	
	@Test
	void mapTest() {
		Date dateTest = Date.from(LocalDate.of(2023, 01, 12).atStartOfDay(ZoneId.systemDefault()).toInstant());
		AccountInformationEntity accountInformationEntity = new AccountInformationEntity();
		accountInformationEntity.setAccountAge(0);
		accountInformationEntity.setAccountBirthday(dateTest);
		accountInformationEntity.setAccountEmail("testMail");
		accountInformationEntity.setAccountId(BigDecimal.valueOf(1));
		accountInformationEntity.setAccountPassword("testPassword");
		accountInformationEntity.setAccountSubscriptionDate(dateTest);
		accountInformationEntity.setAccountUsername("testUsername");
		AccountInformationResponseDto accountInformationResponseDto = mapAccountInformationEntityToAccountInformationResponseDto.map(accountInformationEntity);
		
		assertNotNull(accountInformationResponseDto);
		assertEquals(0, accountInformationResponseDto.getAccountAge());
		assertEquals(dateTest, accountInformationResponseDto.getAccountBirthday());
		assertEquals("testMail", accountInformationResponseDto.getAccountEmail());
		assertEquals(BigDecimal.valueOf(1), accountInformationResponseDto.getAccountId());
		assertEquals("testPassword", accountInformationResponseDto.getAccountPassword());
		assertEquals(dateTest, accountInformationResponseDto.getAccountSubscriptionDate());
		assertEquals("testUsername", accountInformationResponseDto.getAccountUsername());
		
	}
	

}
