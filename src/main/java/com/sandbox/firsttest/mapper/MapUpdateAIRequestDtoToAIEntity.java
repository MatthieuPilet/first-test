package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.UpdateAIRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

@Component
public class MapUpdateAIRequestDtoToAIEntity {

	public AccountInformationEntity map(UpdateAIRequestDto updateAIRequestDto) {
		AccountInformationEntity accountInformationEntity = new AccountInformationEntity();
		accountInformationEntity.setAccountId(updateAIRequestDto.getAccountId());
		accountInformationEntity.setAccountUsername(updateAIRequestDto.getAccountUsername());
		accountInformationEntity.setAccountPassword(updateAIRequestDto.getAccountPassword());
		accountInformationEntity.setAccountEmail(updateAIRequestDto.getAccountEmail());
		return accountInformationEntity;
	}
}
