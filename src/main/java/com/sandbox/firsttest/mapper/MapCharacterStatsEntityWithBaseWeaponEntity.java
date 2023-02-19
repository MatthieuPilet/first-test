package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.entity.CharacterStatsEntity;

/**
 * This mapper is to map CharacterStatsEntity with BaseWeaponEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Component
public class MapCharacterStatsEntityWithBaseWeaponEntity {

	/**
	 * map {@link ChracterStatsEntity} with {@link BaseWeaponEntity}
	 * 
	 * @param baseWeaponEntity {@link BaseWeaponEntity}
	 * @return {@link ChracterStatsEntity}
	 */
	public CharacterStatsEntity map(BaseWeaponEntity baseWeaponEntity) {
		CharacterStatsEntity characterStatsEntity = new CharacterStatsEntity();
		characterStatsEntity.setCharacterAgility(baseWeaponEntity.getBaseStatAgility());
		characterStatsEntity.setCharacterEnergy(baseWeaponEntity.getBaseStatEnergy());
		characterStatsEntity.setCharacterIntelligence(baseWeaponEntity.getBaseStatIntelligence());
		characterStatsEntity.setCharacterLife(100f + (baseWeaponEntity.getBaseStatVitality() * 5));
		characterStatsEntity.setCharacterStealth(baseWeaponEntity.getBaseStatStealth());
		characterStatsEntity.setCharacterStrength(baseWeaponEntity.getBaseStatStrength());
		characterStatsEntity.setCharacterVitality(baseWeaponEntity.getBaseStatVitality());
		characterStatsEntity.setCharacterWisdom(baseWeaponEntity.getBaseStatWisdom());
		return characterStatsEntity;
	}
}
