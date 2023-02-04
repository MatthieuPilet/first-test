/**
 * 
 */
package com.sandbox.firsttest.repositorytest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Sql("/scriptTest/AccountRepositoryTestInit.sql")
@Sql(scripts = "/scriptTest/AccountRepositoryTestUnload.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class AccountRepositoryTest {

	@Autowired
	public IAccountRepository accountRepository;
	
	@Test
	@Order(1)
	void getAccountInformationTest() {
		AccountInformationEntity accountInformationEntity = accountRepository.getAccountInformation(99999999);
		assertEquals(BigInteger.valueOf(99999999), accountInformationEntity.getAccountId());
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
	
	@Test
	@Order(4)
	void updateAccountInformationAllTest() {
		AccountInformationEntity accountInformationEntityParameter = new AccountInformationEntity();
		accountInformationEntityParameter.setAccountId(BigInteger.valueOf(99999997));
		accountInformationEntityParameter.setAccountEmail("test@mail.com");
		accountInformationEntityParameter.setAccountPassword("password");
		accountInformationEntityParameter.setAccountUsername("username");
		
		AccountInformationEntity accountInformationEntityBeforeUpdate = accountRepository.getAccountInformation(99999997);
		AccountInformationEntity accountInformationEntityAfterUpdate = accountRepository.updateAccountInformation(accountInformationEntityParameter);
		assertEquals(accountInformationEntityBeforeUpdate.getAccountId(), accountInformationEntityAfterUpdate.getAccountId());
		assertNotEquals(accountInformationEntityBeforeUpdate.getAccountPassword(), accountInformationEntityAfterUpdate.getAccountPassword());
		assertNotEquals(accountInformationEntityBeforeUpdate.getAccountEmail(), accountInformationEntityAfterUpdate.getAccountEmail());
		assertNotEquals(accountInformationEntityBeforeUpdate.getAccountUsername(), accountInformationEntityAfterUpdate.getAccountUsername());
	}
	
	@Test
	@Order(5)
	void sendWithNoUpdateAccountInformationTest() {
		AccountInformationEntity accountInformationEntityParameter = new AccountInformationEntity();
		accountInformationEntityParameter.setAccountId(BigInteger.valueOf(99999997));
		AccountInformationEntity accountInformationEntityBeforeUpdate = accountRepository.getAccountInformation(99999997);
		AccountInformationEntity accountInformationEntityAfterUpdate = accountRepository.updateAccountInformation(accountInformationEntityParameter);
		assertEquals(accountInformationEntityBeforeUpdate.getAccountId(), accountInformationEntityAfterUpdate.getAccountId());
		assertNotNull(accountInformationEntityAfterUpdate.getAccountPassword());
		assertNotNull(accountInformationEntityAfterUpdate.getAccountEmail());
		assertNotNull(accountInformationEntityAfterUpdate.getAccountUsername());
	}

}
