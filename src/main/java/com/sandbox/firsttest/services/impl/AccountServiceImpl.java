package com.sandbox.firsttest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.firsttest.dto.AccountInformationRequestDto;
import com.sandbox.firsttest.dto.AccountInformationResponseDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.mapper.MapAccountInformationEntityToAccountInformationResponseDto;
import com.sandbox.firsttest.mapper.MapAccountInformationRequestDtoToAccountInformationEntity;
import com.sandbox.firsttest.repository.impl.AccountRepositoryImpl;
import com.sandbox.firsttest.services.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	AccountRepositoryImpl accountRepositoryImpl;
	
	@Autowired
	MapAccountInformationEntityToAccountInformationResponseDto mapAccountInformationEntityToAccountInformationDto;
	@Autowired
	MapAccountInformationRequestDtoToAccountInformationEntity mapAccountInformationRequestDtoToAccountInformationEntity;

	@Override
	public AccountInformationResponseDto getAccountInformation(Integer id) {
		AccountInformationEntity accountInformationEntity = accountRepositoryImpl.getAccountInformation(id);
		return mapAccountInformationEntityToAccountInformationDto.map(accountInformationEntity);
	}

	@Override
	public AccountInformationResponseDto createAccountInformation(
			AccountInformationRequestDto accountInformationRequestDto) {
		AccountInformationEntity accountInformationEntityRequest = mapAccountInformationRequestDtoToAccountInformationEntity.map(accountInformationRequestDto);
		AccountInformationEntity accountInformationEntityResponse = accountRepositoryImpl.createAccountInformation(accountInformationEntityRequest);
		return mapAccountInformationEntityToAccountInformationDto.map(accountInformationEntityResponse);
	}

	@Override
	public void deleteAccountInformation(Integer id) {
		accountRepositoryImpl.deleteAccountInformation(id);
	}

}
