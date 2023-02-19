package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.AIRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

/**
 * This mapper is to map AIRequestDto to AIEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Component
public class MapAIRequestDtoToAIEntity {

	/**
	 * map {@link AIRequestDto} to {@link AccountInformationEntity}
	 * 
	 * @param accountInformationRequestDto {@link AIRequestDto}
	 * @return {@link AccountInformationEntity}
	 */
	public AccountInformationEntity map(AIRequestDto accountInformationRequestDto) {
		AccountInformationEntity accountInformationEntity = new AccountInformationEntity();
		accountInformationEntity.setAccountUsername(accountInformationRequestDto.getAccountUsername());
		accountInformationEntity.setAccountPassword(accountInformationRequestDto.getAccountPassword());
		accountInformationEntity.setAccountEmail(accountInformationRequestDto.getAccountEmail());
		accountInformationEntity.setAccountAge(accountInformationRequestDto.getAccountAge());
		accountInformationEntity.setAccountBirthday(accountInformationRequestDto.getAccountBirthday());
		return accountInformationEntity;
	}
}
