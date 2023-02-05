/**
 * 
 */
package com.sandbox.firsttest.repositorytest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.repository.IBaseWeaponRepository;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@ContextConfiguration(classes = RunApplication.class)
@Sql("/scriptTest/BaseWeaponRepositoryTestInit.sql")
@Sql(scripts = "/scriptTest/BaseWeaponRepositoryTestUnload.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class BaseWeaponRepositoryTest {

	@Autowired
	public IBaseWeaponRepository baseWeaponRepository;
	
	
	@Test
	@Order(1)
	void getBaseWeaponTest() {
		BaseWeaponEntity baseWeaponEntity = baseWeaponRepository.getBaseWeapon(99999999);
		assertNotNull(baseWeaponEntity);
	}

}
