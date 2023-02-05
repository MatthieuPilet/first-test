package com.sandbox.firsttest.services;

import java.util.List;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.dto.UpdateWeaponCharacterRequestDto;

public interface ICharactersService {

	public List<CharacterResponseDto> getCharacters(Integer accountId);
	public CharacterResponseDto getCharacter(Integer characterId);
	public CharacterResponseDto createCharacter(CreateCharacterRequestDto createCharacterRequestDto);
	public CharacterResponseDto updateWeaponCharacter(UpdateWeaponCharacterRequestDto updateWeaponCharacterRequestDto);
}
