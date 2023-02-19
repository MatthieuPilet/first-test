package com.sandbox.firsttest.mapper;

import org.mapstruct.Mapper;

import com.sandbox.firsttest.dto.UpdateAIRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

/**
 * This mapper is to map UpdateAIRequestDto to AIEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Mapper
public interface MapUpdateAIRequestDtoToAIEntity {

	/**
	 * map {@link UpdateAIRequestDto} to {@link AccountInformationEntity}
	 * 
	 * @param updateAIRequestDto {@link UpdateAIRequestDto}
	 * @return {@link AccountInformationEntity}
	 */
	public AccountInformationEntity map(UpdateAIRequestDto updateAIRequestDto);
}
