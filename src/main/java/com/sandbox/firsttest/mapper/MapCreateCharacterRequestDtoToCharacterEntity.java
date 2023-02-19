package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.CharacterEntity;

/**
 * This mapper is to map CreateCharacterRequestDto and AccountInformationEntity to CharacterEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Component
public class MapCreateCharacterRequestDtoToCharacterEntity {

	/**
	 * map {@link CreateCharacterRequestDto} and {@link AccountInformationEntity} to {@link CharacterEntity}
	 * 
	 * @param createCharacterRequestDto {@link CreateCharacterRequestDto}
	 * @param aIEntity {@link AccountInformationEntity}
	 * @return {@link CharacterEntity}
	 */
	public CharacterEntity map(CreateCharacterRequestDto createCharacterRequestDto, AccountInformationEntity aIEntity) {
		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setCharacterName(createCharacterRequestDto.getCharacterName());
		characterEntity.setAccountInformationEntity(aIEntity);
		return characterEntity;
	}
}
