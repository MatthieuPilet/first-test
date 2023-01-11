package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.AccountInformationRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

@Component
public class MapAccountInformationRequestDtoToAccountInformationEntity {

	public AccountInformationEntity map(AccountInformationRequestDto accountInformationRequestDto) {
		AccountInformationEntity accountInformationEntity = new AccountInformationEntity();
		accountInformationEntity.setAccountUsername(accountInformationRequestDto.getAccountUsername());
		accountInformationEntity.setAccountPassword(accountInformationRequestDto.getAccountPassword());
		accountInformationEntity.setAccountEmail(accountInformationRequestDto.getAccountEmail());
		accountInformationEntity.setAccountAge(accountInformationRequestDto.getAccountAge());
		accountInformationEntity.setAccountBirthday(accountInformationRequestDto.getAccountBirthday());
		return accountInformationEntity;
	}
}
