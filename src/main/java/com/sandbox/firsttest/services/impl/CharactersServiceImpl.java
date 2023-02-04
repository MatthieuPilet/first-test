package com.sandbox.firsttest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.mapper.MapCharacterEntityToCharacterResponseDto;
import com.sandbox.firsttest.mapper.MapCreateCharacterRequestDtoToCharacterEntity;
import com.sandbox.firsttest.repository.impl.AccountRepositoryImpl;
import com.sandbox.firsttest.repository.impl.CharactersRepositoryImpl;
import com.sandbox.firsttest.services.ICharactersService;

@Service
public class CharactersServiceImpl implements ICharactersService{
	
	@Autowired
	CharactersRepositoryImpl charactersRepositoryImpl;
	
	@Autowired
	AccountRepositoryImpl accountRepositoryImpl;
	
	@Autowired
	MapCharacterEntityToCharacterResponseDto mapCharacterEntityToCharacterResponseDto;
	
	@Autowired
	MapCreateCharacterRequestDtoToCharacterEntity mapCreateCharacterRequestDtoToCharacterEntity;

	@Override
	public List<CharacterResponseDto> getCharacters(Integer accountId) {
		List<CharacterEntity> characters = charactersRepositoryImpl.getCharacters(accountId);
		return mapCharacterEntityToCharacterResponseDto.mapListToList(characters);
	}

	@Override
	public CharacterResponseDto createCharacter(CreateCharacterRequestDto createCharacterRequestDto) {
		AccountInformationEntity aIEntity = accountRepositoryImpl.getAccountInformation(createCharacterRequestDto.getAccountId());
		CharacterEntity characterEntityRequest = mapCreateCharacterRequestDtoToCharacterEntity.map(createCharacterRequestDto, aIEntity);
		CharacterEntity characterEntityResponse = charactersRepositoryImpl.createCharacter(characterEntityRequest);
		return mapCharacterEntityToCharacterResponseDto.map(characterEntityResponse);
	}
}
