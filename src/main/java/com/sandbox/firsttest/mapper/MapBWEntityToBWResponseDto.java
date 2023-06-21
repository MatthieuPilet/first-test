package com.sandbox.firsttest.mapper;

import org.mapstruct.Mapper;

import com.sandbox.firsttest.dto.BWResponseDto;
import com.sandbox.firsttest.entity.BaseWeaponEntity;

/**
 * This mapper is to map BaseWeaponEntity to BWResponseDto
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Mapper
public interface MapBWEntityToBWResponseDto {

	/**
	 * map {@link BaseWeaponEntity} to {@link BWResponseDto} 
	 * 
	 * @param accountInformationEntity {@link BaseWeaponEntity}
	 * @return {@link BWResponseDto}
	 */
	public BWResponseDto map(BaseWeaponEntity baseWeaponEntity);
}
