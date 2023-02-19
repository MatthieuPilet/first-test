package com.sandbox.firsttest.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.entity.CharacterEntity;

/**
 * This mapper is to map CharacterEntity tp CharacterResponseDto
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Component
public class MapCharacterEntityToCharacterResponseDto {

	/**
	 * map {@link CharacterEntity} to {@link CharacterResponseDto}
	 * 
	 * @param characterEntity {@link CharacterEntity}
	 * @return {@link CharacterResponseDto}
	 */
	public CharacterResponseDto map(CharacterEntity characterEntity) {
		CharacterResponseDto characterResponseDto = new CharacterResponseDto();
		characterResponseDto.setCharacterId(characterEntity.getCharacterId());
		characterResponseDto.setAccountId(characterEntity.getAccountInformationEntity().getAccountId());
		characterResponseDto.setBaseWeaponId(characterEntity.getBaseWeaponEntity() != null ? characterEntity.getBaseWeaponEntity().getBaseWeapondId() : null);
		characterResponseDto.setCharacterName(characterEntity.getCharacterName());
		characterResponseDto.setCharacterTitle(characterEntity.getCharacterTitle());
		if(characterEntity.getCharacterStatsEntity() != null) {
			characterResponseDto.setCharacterStatsId(characterEntity.getCharacterStatsEntity().getCharacterStatsId());
			characterResponseDto.setCharacterAgility(characterEntity.getCharacterStatsEntity().getCharacterAgility());
			characterResponseDto.setCharacterEnergy(characterEntity.getCharacterStatsEntity().getCharacterEnergy());
			characterResponseDto.setCharacterIntelligence(characterEntity.getCharacterStatsEntity().getCharacterIntelligence());
			characterResponseDto.setCharacterLife(characterEntity.getCharacterStatsEntity().getCharacterLife());
			characterResponseDto.setCharacterStealth(characterEntity.getCharacterStatsEntity().getCharacterStealth());
			characterResponseDto.setCharacterStrength(characterEntity.getCharacterStatsEntity().getCharacterStrength());
			characterResponseDto.setCharacterVitality(characterEntity.getCharacterStatsEntity().getCharacterVitality());
			characterResponseDto.setCharacterWisdom(characterEntity.getCharacterStatsEntity().getCharacterWisdom());
		}
		return characterResponseDto;
	}
	
	public List<CharacterResponseDto> mapListToList(List<CharacterEntity> mapCharacterEntity) {
		return mapCharacterEntity.stream().map(this::map).toList();
	}
}
