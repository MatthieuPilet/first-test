package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.entity.CharacterStatsEntity;

/**
 * This mapper is to create CharacterStatsEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Component
public class MapCreateCharacterStatsEntity {
	
	/**
	 * The purpose of this method is to create or update {@link CharacterStatsEntity}
	 * through the first take or update {@link BaseWeaponEntity}
	 * it use and other method {@code calculNewStat}
	 * 
	 * @param {@link BaseWeaponEntity}
	 * @param  {@link CharacterEntity}
	 * @return {@link CharacterEntity} with {@link CharacterStatsEntity} update
	 */
	public CharacterStatsEntity map(BaseWeaponEntity baseWeaponEntity,CharacterEntity characterEntity,BaseWeaponEntity baseWeaponEntityOld) {
		CharacterStatsEntity characterStatsEntity = new CharacterStatsEntity();
		if(baseWeaponEntityOld == null && null != characterEntity.getCharacterStatsEntity()) {
			characterStatsEntity.setCharacterStatsId(
					characterEntity.getCharacterStatsEntity() != null
					? characterEntity.getCharacterStatsEntity().getCharacterStatsId()
					: null);
			characterStatsEntity.setCharacterAgility(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterAgility(),
					baseWeaponEntity.getBaseStatAgility(),
					0)
			);
			characterStatsEntity.setCharacterEnergy(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterEnergy(),
					baseWeaponEntity.getBaseStatEnergy(),
					0)
			);
			characterStatsEntity.setCharacterIntelligence(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterIntelligence(),
					baseWeaponEntity.getBaseStatIntelligence(),
					0)
			);
			characterStatsEntity.setCharacterLife(characterEntity.getCharacterStatsEntity() != null
					? characterEntity.getCharacterStatsEntity().getCharacterLife() + (baseWeaponEntity.getBaseStatVitality() * 5)
					: 100f);
			characterStatsEntity.setCharacterStealth(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterStealth(),
					baseWeaponEntity.getBaseStatStealth(),
					0)
			);
			characterStatsEntity.setCharacterStrength(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterStrength(),
					baseWeaponEntity.getBaseStatStrength(),
					0)
			);
			characterStatsEntity.setCharacterVitality(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterVitality(),
					baseWeaponEntity.getBaseStatVitality(),
					0)
			);
			characterStatsEntity.setCharacterWisdom(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterWisdom(),
					baseWeaponEntity.getBaseStatWisdom(),
					0)
			);
		} else if (baseWeaponEntityOld != null && null != characterEntity.getCharacterStatsEntity()){
			characterStatsEntity.setCharacterStatsId(
					characterEntity.getCharacterStatsEntity() != null
					? characterEntity.getCharacterStatsEntity().getCharacterStatsId()
					: null);
			characterStatsEntity.setCharacterAgility(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterAgility(),
					baseWeaponEntity.getBaseStatAgility(),
					baseWeaponEntityOld.getBaseStatAgility())
			);
			characterStatsEntity.setCharacterEnergy(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterEnergy(),
					baseWeaponEntity.getBaseStatEnergy(),
					baseWeaponEntityOld.getBaseStatEnergy())
			);
			characterStatsEntity.setCharacterIntelligence(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterIntelligence(),
					baseWeaponEntity.getBaseStatIntelligence(),
					baseWeaponEntityOld.getBaseStatIntelligence())
			);
			characterStatsEntity.setCharacterLife(characterEntity.getCharacterStatsEntity() != null
					? characterEntity.getCharacterStatsEntity().getCharacterLife() + (baseWeaponEntity.getBaseStatVitality() * 5) - (baseWeaponEntityOld.getBaseStatVitality() * 5)
					: 100f);
			characterStatsEntity.setCharacterStealth(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterStealth(),
					baseWeaponEntity.getBaseStatStealth(),
					baseWeaponEntityOld.getBaseStatStealth())
			);
			characterStatsEntity.setCharacterStrength(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterStrength(),
					baseWeaponEntity.getBaseStatStrength(),
					baseWeaponEntityOld.getBaseStatStrength())
			);
			characterStatsEntity.setCharacterVitality(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterVitality(),
					baseWeaponEntity.getBaseStatVitality(),
					baseWeaponEntityOld.getBaseStatVitality())
			);
			characterStatsEntity.setCharacterWisdom(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterWisdom(),
					baseWeaponEntity.getBaseStatWisdom(),
					baseWeaponEntityOld.getBaseStatWisdom())
			);
		}
		return characterStatsEntity;
	}
	
	/**
	 * @param characterEntity characterEntity to check Null
	 * @param statToUpdate 
	 * @param baseStat
	 * @param baseStatOld  0 if it's creation
	 * @return The value of the stat
	 */
	private static Integer calculNewStat(CharacterEntity characterEntity, Integer statToUpdate, Integer baseStat, Integer baseStatOld) {
		if(characterEntity.getCharacterStatsEntity() != null) {
			return statToUpdate + baseStat - baseStatOld;
		} else {
			return baseStat;
		}
	}
}
