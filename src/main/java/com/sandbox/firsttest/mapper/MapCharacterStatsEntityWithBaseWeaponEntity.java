package com.sandbox.firsttest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.entity.CharacterStatsEntity;

/**
 * This mapper is to map CharacterStatsEntity with BaseWeaponEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Mapper
public interface MapCharacterStatsEntityWithBaseWeaponEntity {

	/**
	 * map {@link ChracterStatsEntity} with {@link BaseWeaponEntity}
	 * 
	 * @param baseWeaponEntity {@link BaseWeaponEntity}
	 * @return {@link ChracterStatsEntity}
	 */
	@Mapping(target="characterAgility", source = "baseWeaponEntity.baseStatAgility")
	@Mapping(target="characterEnergy", source = "baseWeaponEntity.baseStatEnergy")
	@Mapping(target="characterIntelligence", source = "baseWeaponEntity.baseStatIntelligence")
	@Mapping(target="characterLife", expression = "java(100f + (baseWeaponEntity.getBaseStatVitality() * 5))")
	@Mapping(target="characterStealth", source = "baseWeaponEntity.baseStatStealth")
	@Mapping(target="characterStrength", source = "baseWeaponEntity.baseStatStrength")
	@Mapping(target="characterVitality", source = "baseWeaponEntity.baseStatVitality")
	@Mapping(target="characterWisdom", source = "baseWeaponEntity.baseStatWisdom")
	public CharacterStatsEntity map(BaseWeaponEntity baseWeaponEntity);
}
