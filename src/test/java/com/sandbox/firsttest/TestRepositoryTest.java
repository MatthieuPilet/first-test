/**
 * 
 */
package com.sandbox.firsttest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.repository.ITestRepository;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@Sql("/scriptTest/TestRepositoryTestInit.sql")
@Sql(scripts = "/scriptTest/TestRepositoryTestUnload.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class TestRepositoryTest {

	@Autowired
	public ITestRepository testRepository;
	
	@Test
	void test() {
		AccountInformationEntity accountInformationEntity = testRepository.getAccountInformation(99999999);
		assertEquals(BigDecimal.valueOf(99999999), accountInformationEntity.getAccountId());
	}

}
