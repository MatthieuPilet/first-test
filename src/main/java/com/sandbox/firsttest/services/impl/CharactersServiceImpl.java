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
import com.sandbox.firsttest.mapper.MapCharacterEntityToCharacterResponseDtoImpl;
import com.sandbox.firsttest.mapper.MapCharacterStatsEntityWithBaseWeaponEntityImpl;
import com.sandbox.firsttest.mapper.MapCreateCharacterRequestDtoToCharacterEntityImpl;
import com.sandbox.firsttest.mapper.MapCreateCharacterStatsEntity;
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
	MapCharacterEntityToCharacterResponseDtoImpl mapCharacterEntityToCharacterResponseDto;

	@Autowired
	MapCreateCharacterRequestDtoToCharacterEntityImpl mapCreateCharacterRequestDtoToCharacterEntity;
	
	@Autowired
	MapCharacterStatsEntityWithBaseWeaponEntityImpl mapCharacterStatsEntityWithBaseWeaponEntity;
	
	@Autowired
	MapCreateCharacterStatsEntity mapCreateCharacterStatsEntity;

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
		if(null != characterEntityRequest.getCharacterStatsEntity()) {
			characterEntityRequest.setCharacterStatsEntity(mapCreateCharacterStatsEntity.map(baseWeaponEntity,characterEntityRequest,baseWeaponEntityOld));
		} else {
			characterEntityRequest.setCharacterStatsEntity(mapCharacterStatsEntityWithBaseWeaponEntity.map(baseWeaponEntity));
		}
		CharacterEntity characterEntityResponse = charactersRepositoryImpl
				.updateWeaponCharacter(characterEntityRequest);
		return mapCharacterEntityToCharacterResponseDto.map(characterEntityResponse);
	}
}
