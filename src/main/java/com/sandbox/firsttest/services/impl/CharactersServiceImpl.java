package com.sandbox.firsttest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.mapper.MapCharacterEntityToCharacterResponseDto;
import com.sandbox.firsttest.repository.impl.CharactersRepositoryImpl;
import com.sandbox.firsttest.services.ICharactersService;

@Service
public class CharactersServiceImpl implements ICharactersService{
	
	@Autowired
	CharactersRepositoryImpl charactersRepositoryImpl;
	
	@Autowired
	MapCharacterEntityToCharacterResponseDto mapCharacterEntityToCharacterResponseDto;

	@Override
	public List<CharacterResponseDto> getCharacters(Integer accountId) {
		List<CharacterEntity> characters = charactersRepositoryImpl.getCharacters(accountId);
		return mapCharacterEntityToCharacterResponseDto.mapListToList(characters);
	}
}
