package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.AIResponseDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

/**
 * This mapper is to map AIEntity to AIResponseDto
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Component
public class MapAIEntityToAIResponseDto {

	/**
	 * map {@link AccountInformationEntity} to {@link AIResponseDto} 
	 * 
	 * @param accountInformationEntity {@link AccountInformationEntity}
	 * @return {@link AIResponseDto}
	 */
	public AIResponseDto map(AccountInformationEntity accountInformationEntity) {
		AIResponseDto accountInformationDto = new AIResponseDto();
		accountInformationDto.setAccountId(accountInformationEntity.getAccountId());
		accountInformationDto.setAccountUsername(accountInformationEntity.getAccountUsername());
		accountInformationDto.setAccountPassword(accountInformationEntity.getAccountPassword());
		accountInformationDto.setAccountEmail(accountInformationEntity.getAccountEmail());
		accountInformationDto.setAccountAge(accountInformationEntity.getAccountAge());
		accountInformationDto.setAccountBirthday(accountInformationEntity.getAccountBirthday());
		accountInformationDto.setAccountSubscriptionDate(accountInformationEntity.getAccountSubscriptionDate());
		return accountInformationDto;
	}
}
