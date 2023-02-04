package com.sandbox.firsttest.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.entity.CharacterEntity;

@Component
public class MapCharacterEntityToCharacterResponseDto {

	public CharacterResponseDto map(CharacterEntity characterEntity) {
		CharacterResponseDto characterResponseDto = new CharacterResponseDto();
		characterResponseDto.setCharacterId(characterEntity.getCharacterId());
		characterResponseDto.setAccountId(characterEntity.getAccountInformationEntity().getAccountId());
		characterResponseDto.setBaseWeaponId(characterEntity.getBaseWeaponEntity() != null ? characterEntity.getBaseWeaponEntity().getBaseWeapondId() : null);
		characterResponseDto.setCharacterStatsId(characterEntity.getCharactersStatsEntity() != null ? characterEntity.getCharactersStatsEntity().getCharacterStatsId() : null);
		characterResponseDto.setCharacterName(characterEntity.getCharacterName());
		return characterResponseDto;
	}
	
	public List<CharacterResponseDto> mapListToList(List<CharacterEntity> mapCharacterEntity) {
		return mapCharacterEntity.stream().map(this::map).toList();
	}
}
