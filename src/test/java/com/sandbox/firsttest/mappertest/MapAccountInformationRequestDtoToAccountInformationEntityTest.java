/**
 * 
 */
package com.sandbox.firsttest.mappertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.dto.AccountInformationRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.mapper.MapAccountInformationRequestDtoToAccountInformationEntity;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@ContextConfiguration(classes = RunApplication.class)
@SpringBootTest
class MapAccountInformationRequestDtoToAccountInformationEntityTest {

	@Autowired
	public MapAccountInformationRequestDtoToAccountInformationEntity mapAccountInformationRequestDtoToAccountInformationEntity;
	
	@Test
	void mapTest() {
		Date dateTest = Date.from(LocalDate.of(2023, 01, 12).atStartOfDay(ZoneId.systemDefault()).toInstant());
		AccountInformationRequestDto accountInformationRequestDto = new AccountInformationRequestDto();
		accountInformationRequestDto.setAccountAge(0);
		accountInformationRequestDto.setAccountBirthday(dateTest);
		accountInformationRequestDto.setAccountEmail("testMail");
		accountInformationRequestDto.setAccountPassword("testPassword");
		accountInformationRequestDto.setAccountUsername("testUsername");
		AccountInformationEntity accountInformationEntity = mapAccountInformationRequestDtoToAccountInformationEntity.map(accountInformationRequestDto);
		
		assertNotNull(accountInformationEntity);
		assertEquals(0, accountInformationEntity.getAccountAge());
		assertEquals(dateTest, accountInformationEntity.getAccountBirthday());
		assertEquals("testMail", accountInformationEntity.getAccountEmail());
		assertEquals("testPassword", accountInformationEntity.getAccountPassword());
		assertEquals("testUsername", accountInformationEntity.getAccountUsername());
		
	}
}
