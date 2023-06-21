/**
 * 
 */
package com.sandbox.firsttest.mappertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.entity.CharacterStatsEntity;
import com.sandbox.firsttest.mapper.MapCreateCharacterStatsEntity;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@ContextConfiguration(classes = RunApplication.class)
@SpringBootTest
class MapCreateCharacterStatsEntityTest {

	@Autowired
	public MapCreateCharacterStatsEntity mapCreateCharacterStatsEntity;
	
	@Test
	void mapTestNotNull() {
		BaseWeaponEntity baseWeaponEntity = new BaseWeaponEntity();
		baseWeaponEntity.setBaseStatAgility(2);
		baseWeaponEntity.setBaseStatEnergy(2);
		baseWeaponEntity.setBaseStatIntelligence(2);
		baseWeaponEntity.setBaseStatStealth(2);
		baseWeaponEntity.setBaseStatStrength(2);
		baseWeaponEntity.setBaseStatVitality(2);
		baseWeaponEntity.setBaseStatWisdom(2);
		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setCharacterId(BigInteger.valueOf(1));
		BaseWeaponEntity baseWeaponEntityOld = new BaseWeaponEntity();
		baseWeaponEntityOld.setBaseStatAgility(1);
		baseWeaponEntityOld.setBaseStatEnergy(1);
		baseWeaponEntityOld.setBaseStatIntelligence(1);
		baseWeaponEntityOld.setBaseStatStealth(1);
		baseWeaponEntityOld.setBaseStatStrength(1);
		baseWeaponEntityOld.setBaseStatVitality(1);
		baseWeaponEntityOld.setBaseStatWisdom(1);
		CharacterStatsEntity characterStatsEntity = new CharacterStatsEntity();
		characterStatsEntity.setCharacterAgility(1);
		characterStatsEntity.setCharacterEnergy(1);
		characterStatsEntity.setCharacterIntelligence(1);
		characterStatsEntity.setCharacterLife(5f);
		characterStatsEntity.setCharacterStatsId(BigInteger.valueOf(1));
		characterStatsEntity.setCharacterStealth(1);
		characterStatsEntity.setCharacterStrength(1);
		characterStatsEntity.setCharacterVitality(1);
		characterStatsEntity.setCharacterWisdom(1);
		
		characterEntity.setCharacterStatsEntity(characterStatsEntity);
		
		CharacterStatsEntity result = mapCreateCharacterStatsEntity.map(baseWeaponEntity,characterEntity,baseWeaponEntityOld);
		
		assertNotNull(result);
		assertEquals(2, result.getCharacterAgility());
		assertEquals(2, result.getCharacterEnergy());
		assertEquals(10f, result.getCharacterLife());
		assertEquals(BigInteger.valueOf(1), result.getCharacterStatsId());
	}
	
	@Test
	void mapTestNull() {
		BaseWeaponEntity baseWeaponEntity = new BaseWeaponEntity();
		baseWeaponEntity.setBaseStatAgility(2);
		baseWeaponEntity.setBaseStatEnergy(2);
		baseWeaponEntity.setBaseStatIntelligence(2);
		baseWeaponEntity.setBaseStatStealth(2);
		baseWeaponEntity.setBaseStatStrength(2);
		baseWeaponEntity.setBaseStatVitality(2);
		baseWeaponEntity.setBaseStatWisdom(2);
		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setCharacterId(BigInteger.valueOf(1));
		BaseWeaponEntity baseWeaponEntityOld = null;
		CharacterStatsEntity characterStatsEntity = new CharacterStatsEntity();
		characterStatsEntity.setCharacterAgility(0);
		characterStatsEntity.setCharacterEnergy(0);
		characterStatsEntity.setCharacterIntelligence(0);
		characterStatsEntity.setCharacterLife(0f);
		characterStatsEntity.setCharacterStatsId(BigInteger.valueOf(1));
		characterStatsEntity.setCharacterStealth(0);
		characterStatsEntity.setCharacterStrength(0);
		characterStatsEntity.setCharacterVitality(0);
		characterStatsEntity.setCharacterWisdom(0);
		
		characterEntity.setCharacterStatsEntity(characterStatsEntity);
		
		CharacterStatsEntity result = mapCreateCharacterStatsEntity.map(baseWeaponEntity,characterEntity,baseWeaponEntityOld);
		
		assertNotNull(result);
		assertEquals(2, result.getCharacterAgility());
		assertEquals(2, result.getCharacterEnergy());
		assertEquals(10f, result.getCharacterLife());
		assertEquals(BigInteger.valueOf(1), result.getCharacterStatsId());
	}
}
