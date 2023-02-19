package com.sandbox.firsttest.repository;

import java.util.List;

import com.sandbox.firsttest.entity.CharacterEntity;

/**
 * This interface is for all operation about character entity
 * 
 * @author Matthieu p
 * @version 1.0
 */
public interface ICharactersRepository {
	
	/**
	 * Get a list of character by account id
	 * 
	 * @param accountId the id of the account
	 * @return List<{@link CharacterEntity}>
	 */
	public List<CharacterEntity> getCharacters(Integer accountId);
	
	/**
	 * Get character by id
	 * 
	 * @param characterId the id of the character
	 * @return {@link CharacterEntity}
	 */
	public CharacterEntity getCharacter(Integer characterId);
	
	/**
	 * Create a character
	 * 
	 * @param createCharacterRequestEntity {@link CharacterEntity}
	 * @return {@link CharacterEntity}
	 */
	public CharacterEntity createCharacter(CharacterEntity createCharacterRequestEntity);
	
	/**
	 * Update a character
	 * 
	 * @param updateWeaponCharacterEntity {@link CharacterEntity}
	 * @return {@link CharacterEntity}
	 */
	public CharacterEntity updateWeaponCharacter(CharacterEntity updateWeaponCharacterEntity);
}
