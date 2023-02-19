package com.sandbox.firsttest.mapper;

import org.mapstruct.Mapper;

import com.sandbox.firsttest.dto.AIRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

/**
 * This mapper is to map AIRequestDto to AIEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Mapper
public interface MapAIRequestDtoToAIEntity {

	/**
	 * map {@link AIRequestDto} to {@link AccountInformationEntity}
	 * 
	 * @param accountInformationRequestDto {@link AIRequestDto}
	 * @return {@link AccountInformationEntity}
	 */
	public AccountInformationEntity map(AIRequestDto accountInformationRequestDto);
}
