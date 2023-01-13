/**
 * 
 */
package com.sandbox.firsttest.repositorytest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.repository.IAccountRepository;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@ContextConfiguration(classes = RunApplication.class)
@Sql("/scriptTest/AccountRepositoryTestInit.sql")
@Sql(scripts = "/scriptTest/AccountRepositoryTestUnload.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class AccountRepositoryTest {

	@Autowired
	public IAccountRepository accountRepository;
	
	@Test
	@Order(1)
	void getAccountInformationTest() {
		AccountInformationEntity accountInformationEntity = accountRepository.getAccountInformation(99999999);
		assertEquals(BigDecimal.valueOf(99999999), accountInformationEntity.getAccountId());
	}
	
	@Test
	@Order(2)
	void createAccountInformationTest() {

		AccountInformationEntity accountInformationEntityRequest = new AccountInformationEntity();
		accountInformationEntityRequest.setAccountAge(10);
		accountInformationEntityRequest.setAccountBirthday(Date.from(LocalDate.of(2000, 10, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		accountInformationEntityRequest.setAccountEmail("test@mail.com");
		accountInformationEntityRequest.setAccountId(null);
		accountInformationEntityRequest.setAccountPassword("password");
		accountInformationEntityRequest.setAccountSubscriptionDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		accountInformationEntityRequest.setAccountUsername("username");
		AccountInformationEntity accountInformationEntity = accountRepository.createAccountInformation(accountInformationEntityRequest);
		
		assertNotNull(accountInformationEntity.getAccountId());
	}
	
	@Test
	@Order(3)
	void deleteAccountInformationTest() {
		accountRepository.deleteAccountInformation(99999998);
		assertNull(accountRepository.getAccountInformation(99999998));
	}

}
