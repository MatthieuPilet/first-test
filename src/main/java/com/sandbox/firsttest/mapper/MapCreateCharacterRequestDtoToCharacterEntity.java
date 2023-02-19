package com.sandbox.firsttest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.CharacterEntity;

/**
 * This mapper is to map CreateCharacterRequestDto and AccountInformationEntity to CharacterEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Mapper
public interface MapCreateCharacterRequestDtoToCharacterEntity {

	/**
	 * map {@link CreateCharacterRequestDto} and {@link AccountInformationEntity} to {@link CharacterEntity}
	 * 
	 * @param createCharacterRequestDto {@link CreateCharacterRequestDto}
	 * @param aIEntity {@link AccountInformationEntity}
	 * @return {@link CharacterEntity}
	 */
	@Mapping(target="accountInformationEntity", source="aIEntity")
	public CharacterEntity map(CreateCharacterRequestDto createCharacterRequestDto, AccountInformationEntity aIEntity);
}
