package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.CharacterEntity;

@Component
public class MapCreateCharacterRequestDtoToCharacterEntity {

	public CharacterEntity map(CreateCharacterRequestDto createCharacterRequestDto, AccountInformationEntity aIEntity) {
		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setCharacterName(createCharacterRequestDto.getCharacterName());
		characterEntity.setAccountInformationEntity(aIEntity);
		return characterEntity;
	}
}
