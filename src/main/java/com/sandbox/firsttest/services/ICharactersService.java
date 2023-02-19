package com.sandbox.firsttest.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.dto.UpdateWeaponCharacterRequestDto;

/**
 * This interface is for all services about characters
 * 
 * @author Matthieu P
 * @version 1.0
 */
public interface ICharactersService {

	/**
	 * Get a list of character by account id
	 * 
	 * @param accountId the id of the account
	 * @return List<{@link CharacterResponseDto}>
	 */
	@Transactional(readOnly = true)
	public List<CharacterResponseDto> getCharacters(Integer accountId);
	
	/**
	 * Get a character by id
	 * 
	 * @param characterId the id of the character
	 * @return {@link CharacterResponseDto}
	 */
	@Transactional(readOnly = true)
	public CharacterResponseDto getCharacter(Integer characterId);
	
	/** 
	 * Create a character 
	 * 
	 * @param createCharacterRequestDto {@link CreateCharacterRequestDto}
	 * @return {@link CharacterResponseDto}
	 */
	@Transactional
	public CharacterResponseDto createCharacter(CreateCharacterRequestDto createCharacterRequestDto);
	
	/**
	 * Update the base weapon of the character
	 * 
	 * @param updateWeaponCharacterRequestDto {@link UpdateWeaponCharacterRequestDto}
	 * @return {@link CharacterResponseDto}
	 */
	@Transactional
	public CharacterResponseDto updateWeaponCharacter(UpdateWeaponCharacterRequestDto updateWeaponCharacterRequestDto);
}
