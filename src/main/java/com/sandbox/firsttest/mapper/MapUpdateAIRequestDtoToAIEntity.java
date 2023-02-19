package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.UpdateAIRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

/**
 * This mapper is to map UpdateAIRequestDto to AIEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Component
public class MapUpdateAIRequestDtoToAIEntity {

	/**
	 * map {@link UpdateAIRequestDto} to {@link AccountInformationEntity}
	 * 
	 * @param updateAIRequestDto {@link UpdateAIRequestDto}
	 * @return {@link AccountInformationEntity}
	 */
	public AccountInformationEntity map(UpdateAIRequestDto updateAIRequestDto) {
		AccountInformationEntity accountInformationEntity = new AccountInformationEntity();
		accountInformationEntity.setAccountId(updateAIRequestDto.getAccountId());
		accountInformationEntity.setAccountUsername(updateAIRequestDto.getAccountUsername());
		accountInformationEntity.setAccountPassword(updateAIRequestDto.getAccountPassword());
		accountInformationEntity.setAccountEmail(updateAIRequestDto.getAccountEmail());
		return accountInformationEntity;
	}
}
