package com.sandbox.firsttest.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.entity.CharacterEntity;

@Component
public class MapCharacterEntityToCharacterResponseDto {

	public CharacterResponseDto map(CharacterEntity characterEntity) {
		CharacterResponseDto characterResponseDto = new CharacterResponseDto();
		characterResponseDto.setAccountId(characterEntity.getAccountInformationEntity().getAccountId());
		characterResponseDto.setBaseWeaponId(characterEntity.getBaseWeaponEntity().getBaseWeapondId());
		characterResponseDto.setCharacterAgility(characterEntity.getCharacterAgility());
		characterResponseDto.setCharacterEnergy(characterEntity.getCharacterEnergy());
		characterResponseDto.setCharacterId(characterEntity.getCharacterId());
		characterResponseDto.setCharacterIntelligence(characterEntity.getCharacterIntelligence());
		characterResponseDto.setCharacterLife(characterEntity.getCharacterLife());
		characterResponseDto.setCharacterName(characterEntity.getCharacterName());
		characterResponseDto.setCharacterStealth(characterEntity.getCharacterStealth());
		characterResponseDto.setCharacterStrength(characterEntity.getCharacterStrength());
		characterResponseDto.setCharacterTitle(characterEntity.getCharacterTitle());
		characterResponseDto.setCharacterVitality(characterEntity.getCharacterVitality());
		characterResponseDto.setCharacterWisdom(characterEntity.getCharacterWisdom());
		return characterResponseDto;
	}
	
	public List<CharacterResponseDto> mapListToList(List<CharacterEntity> mapCharacterEntity) {
		return mapCharacterEntity.stream().map(this::map).toList();
	}
}
