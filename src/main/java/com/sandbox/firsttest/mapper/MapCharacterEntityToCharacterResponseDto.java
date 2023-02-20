package com.sandbox.firsttest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.entity.CharacterEntity;

/**
 * This mapper is to map CharacterEntity tp CharacterResponseDto
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Mapper
public interface MapCharacterEntityToCharacterResponseDto {

	/**
	 * map {@link CharacterEntity} to {@link CharacterResponseDto}
	 * 
	 * @param characterEntity {@link CharacterEntity}
	 * @return {@link CharacterResponseDto}
	 */
	@Mapping(target="accountId", source = "characterEntity.accountInformationEntity.accountId")
	@Mapping(target="baseWeaponId", source = "characterEntity.baseWeaponEntity.baseWeapondId")
	@Mapping(target="characterStatsId", source = "characterEntity.characterStatsEntity.characterStatsId")
	@Mapping(target="characterAgility", source = "characterEntity.characterStatsEntity.characterAgility")
	@Mapping(target="characterEnergy", source = "characterEntity.characterStatsEntity.characterEnergy")
	@Mapping(target="characterIntelligence", source = "characterEntity.characterStatsEntity.characterIntelligence")
	@Mapping(target="characterLife", source = "characterEntity.characterStatsEntity.characterLife")
	@Mapping(target="characterStealth", source = "characterEntity.characterStatsEntity.characterStealth")
	@Mapping(target="characterStrength", source = "characterEntity.characterStatsEntity.characterStrength")
	@Mapping(target="characterVitality", source = "characterEntity.characterStatsEntity.characterVitality")
	@Mapping(target="characterWisdom", source = "characterEntity.characterStatsEntity.characterWisdom")
	public CharacterResponseDto map(CharacterEntity characterEntity);
	
	public List<CharacterResponseDto> mapListToList(List<CharacterEntity> mapCharacterEntity) ;
}
