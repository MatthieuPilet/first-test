/**
 * 
 */
package com.sandbox.firsttest.repositorytest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.repository.IAccountRepository;
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
	
	@Autowired
	public IAccountRepository accountRepository;
	
	@Test
	@Order(1)
	void getCharactersTest() {
		List<CharacterEntity> charactersEntity = characterRepository.getCharacters(99999996);
		assertEquals(2, charactersEntity.size());
	}
	
	@Test
	@Order(2)
	void createCharacterTest() {
		AccountInformationEntity accountInformationEntity = new AccountInformationEntity();
		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setAccountInformationEntity(accountInformationEntity);
		characterEntity.setCharacterName("testCreate3");
		CharacterEntity entityCreate = characterRepository.createCharacter(characterEntity);
		assertNotNull(entityCreate.getCharacterId());
	}

}
