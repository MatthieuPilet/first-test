package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.AIRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

@Component
public class MapAIRequestDtoToAIEntity {

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
