package com.sandbox.firsttest.mapper;

import org.springframework.stereotype.Component;

import com.sandbox.firsttest.dto.AccountInformationDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;

@Component
public class MapAccountInformationEntityToAccountInformationDto {

	public AccountInformationDto map(AccountInformationEntity accountInformationEntity) {
		AccountInformationDto accountInformationDto = new AccountInformationDto();
		accountInformationDto.setAccountId(accountInformationEntity.getAccountId());
		accountInformationDto.setAccountUsername(accountInformationEntity.getAccountUsername());
		accountInformationDto.setAccountPassword(accountInformationEntity.getAccountPassword());
		accountInformationDto.setAccountEmail(accountInformationEntity.getAccountEmail());
		accountInformationDto.setAccountAge(accountInformationEntity.getAccountAge());
		accountInformationDto.setAccount_birthday(accountInformationEntity.getAccount_birthday());
		accountInformationDto.setAccount_subscription_date(accountInformationEntity.getAccount_subscription_date());
		return accountInformationDto;
	}
}
