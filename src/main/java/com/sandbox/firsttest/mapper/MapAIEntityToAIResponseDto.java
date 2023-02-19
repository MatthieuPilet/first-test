package com.sandbox.firsttest.mapper;

import org.mapstruct.Mapper;

import com.sandbox.firsttest.dto.AIResponseDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

/**
 * This mapper is to map AIEntity to AIResponseDto
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Mapper
public interface MapAIEntityToAIResponseDto {

	/**
	 * map {@link AccountInformationEntity} to {@link AIResponseDto} 
	 * 
	 * @param accountInformationEntity {@link AccountInformationEntity}
	 * @return {@link AIResponseDto}
	 */
	public AIResponseDto map(AccountInformationEntity accountInformationEntity);
}
