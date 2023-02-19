package com.sandbox.firsttest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.firsttest.dto.CharacterResponseDto;
import com.sandbox.firsttest.dto.CreateCharacterRequestDto;
import com.sandbox.firsttest.dto.UpdateWeaponCharacterRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.entity.CharacterStatsEntity;
import com.sandbox.firsttest.mapper.MapCharacterEntityToCharacterResponseDto;
import com.sandbox.firsttest.mapper.MapCharacterStatsEntityWithBaseWeaponEntity;
import com.sandbox.firsttest.mapper.MapCreateCharacterRequestDtoToCharacterEntity;
import com.sandbox.firsttest.repository.impl.AccountRepositoryImpl;
import com.sandbox.firsttest.repository.impl.BaseWeaponRepositoryImpl;
import com.sandbox.firsttest.repository.impl.CharactersRepositoryImpl;
import com.sandbox.firsttest.services.ICharactersService;

@Service
public class CharactersServiceImpl implements ICharactersService {

	@Autowired
	CharactersRepositoryImpl charactersRepositoryImpl;

	@Autowired
	AccountRepositoryImpl accountRepositoryImpl;

	@Autowired
	BaseWeaponRepositoryImpl baseWeaponRepositoryImpl;

	@Autowired
	MapCharacterEntityToCharacterResponseDto mapCharacterEntityToCharacterResponseDto;

	@Autowired
	MapCreateCharacterRequestDtoToCharacterEntity mapCreateCharacterRequestDtoToCharacterEntity;
	
	@Autowired
	MapCharacterStatsEntityWithBaseWeaponEntity mapCharacterStatsEntityWithBaseWeaponEntity;

	@Override
	public List<CharacterResponseDto> getCharacters(Integer accountId) {
		List<CharacterEntity> characters = charactersRepositoryImpl.getCharacters(accountId);
		return mapCharacterEntityToCharacterResponseDto.mapListToList(characters);
	}

	@Override
	public CharacterResponseDto getCharacter(Integer characterId) {
		CharacterEntity character = charactersRepositoryImpl.getCharacter(characterId);
		return mapCharacterEntityToCharacterResponseDto.map(character);
	}

	@Override
	public CharacterResponseDto createCharacter(CreateCharacterRequestDto createCharacterRequestDto) {
		AccountInformationEntity aIEntity = accountRepositoryImpl
				.getAccountInformation(createCharacterRequestDto.getAccountId());
		CharacterEntity characterEntityRequest = mapCreateCharacterRequestDtoToCharacterEntity
				.map(createCharacterRequestDto, aIEntity);
		CharacterEntity characterEntityResponse = charactersRepositoryImpl.createCharacter(characterEntityRequest);
		return mapCharacterEntityToCharacterResponseDto.map(characterEntityResponse);
	}

	@Override
	public CharacterResponseDto updateWeaponCharacter(UpdateWeaponCharacterRequestDto updateWeaponCharacterRequestDto) {

		
		BaseWeaponEntity baseWeaponEntity = baseWeaponRepositoryImpl
				.getBaseWeapon(updateWeaponCharacterRequestDto.getBaseWeaponId());
		CharacterEntity characterEntityRequest = charactersRepositoryImpl
				.getCharacter(updateWeaponCharacterRequestDto.getCharacterId());
		BaseWeaponEntity baseWeaponEntityOld = null;
		if (null != characterEntityRequest.getBaseWeaponEntity()) {
			baseWeaponEntityOld = baseWeaponRepositoryImpl
					.getBaseWeapon(characterEntityRequest.getBaseWeaponEntity().getBaseWeapondId().intValue());
		}
		characterEntityRequest.setBaseWeaponEntity(baseWeaponEntity);
		characterEntityRequest.setCharacterStatsEntity(createCharacterStatsEntity(baseWeaponEntity,characterEntityRequest,baseWeaponEntityOld));
		CharacterEntity characterEntityResponse = charactersRepositoryImpl
				.updateWeaponCharacter(characterEntityRequest);
		return mapCharacterEntityToCharacterResponseDto.map(characterEntityResponse);
	}

	/**
	 * The purpose of this method is to create or update {@link CharacterStatsEntity}
	 * through the first take or update {@link BaseWeaponEntity}
	 * it use and other method {@code calculNewStat}
	 * 
	 * @param {@link BaseWeaponEntity}
	 * @param  {@link CharacterEntity}
	 * @return {@link CharacterEntity} with {@link CharacterStatsEntity} update
	 */
	private CharacterStatsEntity createCharacterStatsEntity(BaseWeaponEntity baseWeaponEntity,CharacterEntity characterEntity,BaseWeaponEntity baseWeaponEntityOld) {
		CharacterStatsEntity characterStatsEntity = new CharacterStatsEntity();
		if(baseWeaponEntityOld == null && null != characterEntity.getCharacterStatsEntity()) {
			characterStatsEntity.setCharacterStatsId(
					characterEntity.getCharacterStatsEntity() != null
					? characterEntity.getCharacterStatsEntity().getCharacterStatsId()
					: null);
			characterStatsEntity.setCharacterAgility(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterAgility(),
					baseWeaponEntity.getBaseStatAgility(),
					0)
			);
			characterStatsEntity.setCharacterEnergy(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterEnergy(),
					baseWeaponEntity.getBaseStatEnergy(),
					0)
			);
			characterStatsEntity.setCharacterIntelligence(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterIntelligence(),
					baseWeaponEntity.getBaseStatIntelligence(),
					0)
			);
			characterStatsEntity.setCharacterLife(characterEntity.getCharacterStatsEntity() != null
					? characterEntity.getCharacterStatsEntity().getCharacterLife() + (baseWeaponEntity.getBaseStatVitality() * 5)
					: 100f);
			characterStatsEntity.setCharacterStealth(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterStealth(),
					baseWeaponEntity.getBaseStatStealth(),
					0)
			);
			characterStatsEntity.setCharacterStrength(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterStrength(),
					baseWeaponEntity.getBaseStatStrength(),
					0)
			);
			characterStatsEntity.setCharacterVitality(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterVitality(),
					baseWeaponEntity.getBaseStatVitality(),
					0)
			);
			characterStatsEntity.setCharacterWisdom(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterWisdom(),
					baseWeaponEntity.getBaseStatWisdom(),
					0)
			);
		} else if (baseWeaponEntityOld != null && null != characterEntity.getCharacterStatsEntity()){
			characterStatsEntity.setCharacterStatsId(
					characterEntity.getCharacterStatsEntity() != null
					? characterEntity.getCharacterStatsEntity().getCharacterStatsId()
					: null);
			characterStatsEntity.setCharacterAgility(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterAgility(),
					baseWeaponEntity.getBaseStatAgility(),
					baseWeaponEntityOld.getBaseStatAgility())
			);
			characterStatsEntity.setCharacterEnergy(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterEnergy(),
					baseWeaponEntity.getBaseStatEnergy(),
					baseWeaponEntityOld.getBaseStatEnergy())
			);
			characterStatsEntity.setCharacterIntelligence(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterIntelligence(),
					baseWeaponEntity.getBaseStatIntelligence(),
					baseWeaponEntityOld.getBaseStatIntelligence())
			);
			characterStatsEntity.setCharacterLife(characterEntity.getCharacterStatsEntity() != null
					? characterEntity.getCharacterStatsEntity().getCharacterLife() + (baseWeaponEntity.getBaseStatVitality() * 5) - (baseWeaponEntityOld.getBaseStatVitality() * 5)
					: 100f);
			characterStatsEntity.setCharacterStealth(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterStealth(),
					baseWeaponEntity.getBaseStatStealth(),
					baseWeaponEntityOld.getBaseStatStealth())
			);
			characterStatsEntity.setCharacterStrength(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterStrength(),
					baseWeaponEntity.getBaseStatStrength(),
					baseWeaponEntityOld.getBaseStatStrength())
			);
			characterStatsEntity.setCharacterVitality(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterVitality(),
					baseWeaponEntity.getBaseStatVitality(),
					baseWeaponEntityOld.getBaseStatVitality())
			);
			characterStatsEntity.setCharacterWisdom(calculNewStat(
					characterEntity, 
					characterEntity.getCharacterStatsEntity().getCharacterWisdom(),
					baseWeaponEntity.getBaseStatWisdom(),
					baseWeaponEntityOld.getBaseStatWisdom())
			);
		} else {
			characterStatsEntity = mapCharacterStatsEntityWithBaseWeaponEntity.map(baseWeaponEntity);
		}
		return characterStatsEntity;
	}

	/**
	 * @param characterEntity characterEntity to check Null
	 * @param statToUpdate 
	 * @param baseStat
	 * @param baseStatOld  0 if it's creation
	 * @return The value of the stat
	 */
	private Integer calculNewStat(CharacterEntity characterEntity, Integer statToUpdate, Integer baseStat, Integer baseStatOld) {
		if(characterEntity.getCharacterStatsEntity() != null) {
			return statToUpdate + baseStat - baseStatOld;
		} else {
			return baseStat;
		}
	}
}
