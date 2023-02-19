/**
 * 
 */
package com.sandbox.firsttest.mappertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.entity.CharacterStatsEntity;
import com.sandbox.firsttest.mapper.MapCharacterStatsEntityWithBaseWeaponEntity;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@ContextConfiguration(classes = RunApplication.class)
@SpringBootTest
class MapCharacterStatsEntityWithBaseWeaponEntityTest {

	@Autowired
	public MapCharacterStatsEntityWithBaseWeaponEntity mapCharacterStatsEntityWithBaseWeaponEntity;
	
	@Test
	void mapTest() {
		BaseWeaponEntity baseWeaponEntity = new BaseWeaponEntity();
		baseWeaponEntity.setBaseStatAgility(5);
		baseWeaponEntity.setBaseStatEnergy(5);
		baseWeaponEntity.setBaseStatIntelligence(5);
		baseWeaponEntity.setBaseStatStealth(5);
		baseWeaponEntity.setBaseStatStrength(5);
		baseWeaponEntity.setBaseStatVitality(5);
		baseWeaponEntity.setBaseStatWisdom(5);
		CharacterStatsEntity characterStatsEntity = mapCharacterStatsEntityWithBaseWeaponEntity.map(baseWeaponEntity);
		
		assertNotNull(characterStatsEntity);
		assertEquals(5, characterStatsEntity.getCharacterAgility());
		assertEquals(5, characterStatsEntity.getCharacterEnergy());
		assertEquals(5, characterStatsEntity.getCharacterIntelligence());
		assertEquals(125f, characterStatsEntity.getCharacterLife());
		assertEquals(5, characterStatsEntity.getCharacterStealth());
		assertEquals(5, characterStatsEntity.getCharacterStrength());
		assertEquals(5, characterStatsEntity.getCharacterVitality());
		assertEquals(5, characterStatsEntity.getCharacterWisdom());
	}
	

}
