/**
 * 
 */
package com.sandbox.firsttest.repositorytest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.entity.CharacterStatsEntity;
import com.sandbox.firsttest.repository.ICharacterStatsRepository;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@ContextConfiguration(classes = RunApplication.class)
@Sql(scripts = "/scriptTest/CharacterStatsRepositoryTestInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/scriptTest/CharacterStatsRepositoryTestUnload.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class CharacterStatsRepositoryTest {

	@Autowired
	public ICharacterStatsRepository characterStatsRepository;
	
	@Test
	@Order(1)
	void getCharacterStatsTest() {
		CharacterStatsEntity characterStatsEntity = characterStatsRepository.getCharacterStats(BigInteger.valueOf(99999999));
		assertNotNull(characterStatsEntity);
		assertEquals(8, characterStatsEntity.getCharacterStrength());
	}

	@Test
	@Order(1)
	void updateCharacterStatsTest() {
		CharacterStatsEntity characterStatsEntity = characterStatsRepository.getCharacterStats(BigInteger.valueOf(99999999));
		assertEquals(8, characterStatsEntity.getCharacterStrength());
		assertEquals(9, characterStatsEntity.getCharacterAgility());
		assertEquals(4, characterStatsEntity.getCharacterVitality());
		characterStatsEntity.setCharacterStrength(10);
		characterStatsEntity.setCharacterAgility(10);
		characterStatsEntity.setCharacterVitality(10);
		CharacterStatsEntity characterStatsEntityUpdate = characterStatsRepository.updateCharacterStats(characterStatsEntity);
		assertNotNull(characterStatsEntityUpdate);
	}

}
