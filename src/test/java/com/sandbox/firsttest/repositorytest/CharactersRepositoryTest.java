/**
 * 
 */
package com.sandbox.firsttest.repositorytest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.repository.ICharactersRepository;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@ContextConfiguration(classes = RunApplication.class)
@Sql("/scriptTest/CharactersRepositoryTestInit.sql")
@Sql(scripts = "/scriptTest/CharactersRepositoryTestUnload.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class CharactersRepositoryTest {

	@Autowired
	public ICharactersRepository characterRepository;
	
	@Test
	@Order(1)
	void getCharactersTest() {
		List<CharacterEntity> charactersEntity = characterRepository.getCharacters(99999996);
		assertEquals(2, charactersEntity.size());
	}

}
