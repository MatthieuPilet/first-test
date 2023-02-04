package com.sandbox.firsttest.repository;

import java.util.List;

import com.sandbox.firsttest.entity.CharacterEntity;

public interface ICharactersRepository {
	public List<CharacterEntity> getCharacters(Integer accountId);
	public CharacterEntity createCharacter(CharacterEntity createCharacterRequestEntity);
}
