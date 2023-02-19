/**
 * 
 */
package com.sandbox.firsttest.repositorytest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.repository.IAccountRepository;
import com.sandbox.firsttest.repository.IBaseWeaponRepository;
import com.sandbox.firsttest.repository.ICharactersRepository;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@ContextConfiguration(classes = RunApplication.class)
@Sql(scripts = "/scriptTest/CharactersRepositoryTestInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/scriptTest/CharactersRepositoryTestUnload.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class CharactersRepositoryTest {

	@Autowired
	public ICharactersRepository characterRepository;
	
	@Autowired
	public IBaseWeaponRepository baseWeaponRepository;
	
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
	void getCharacterTest() {
		CharacterEntity charactersEntity = characterRepository.getCharacter(99999999);
		assertNotNull(charactersEntity);
	}
	
	@Test
	@Order(3)
	void createCharacterTest() {
		AccountInformationEntity accountInformationEntity = accountRepository.getAccountInformation(99999996);
		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setAccountInformationEntity(accountInformationEntity);
		characterEntity.setCharacterName("testCreate3");
		CharacterEntity entityCreate = characterRepository.createCharacter(characterEntity);
		assertNotNull(entityCreate.getCharacterId());
	}
	
	@Test
	@Order(4)
	void updateWeaponCharacterTest() {
		BaseWeaponEntity baseWeaponEntity = baseWeaponRepository.getBaseWeapon(99999999);
		CharacterEntity characterEntity = characterRepository.getCharacter(99999998);
		characterEntity.setBaseWeaponEntity(baseWeaponEntity);
		CharacterEntity entityUpdate = characterRepository.updateWeaponCharacter(characterEntity);
		assertNotNull(entityUpdate.getCharacterId());
		assertNotNull(entityUpdate.getBaseWeaponEntity());
		assertEquals(BigInteger.valueOf(99999999), entityUpdate.getBaseWeaponEntity().getBaseWeapondId());
	}

}
