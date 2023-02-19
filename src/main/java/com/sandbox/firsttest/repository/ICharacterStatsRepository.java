package com.sandbox.firsttest.repository;

import java.math.BigInteger;

import com.sandbox.firsttest.entity.CharacterStatsEntity;

/**
 * This interface is to make all functionnal rules of Character
 * 
 * @author Matthieu P
 * @version 1.0
 */
public interface ICharacterStatsRepository {
	
	/**
	 * The purpose of this method is to get the Stats of one {@link CharacterEntity}
	 * 
	 * @param characterStatsId the id of the {@link CharacterEntity}
	 * @return {@link CharacterStatsEntity}
	 */
	public CharacterStatsEntity getCharacterStats(BigInteger characterStatsId);
	
	/**
	 * The purpose of this method is to update the {@link CharacterStatsEntity}
	 * 
	 * @param characterStatsEntity the entity before update
	 * @return {@link CharacterStatsEntity} the entity after update
	 */
	public CharacterStatsEntity updateCharacterStats(CharacterStatsEntity characterStatsEntity);
}
