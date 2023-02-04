package com.sandbox.firsttest.services;

import java.util.List;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.dto.CreateCharacterRequestDto;

public interface ICharactersService {

	public List<CharacterResponseDto> getCharacters(Integer accountId);
	public CharacterResponseDto createCharacter(CreateCharacterRequestDto createCharacterRequestDto);
}
