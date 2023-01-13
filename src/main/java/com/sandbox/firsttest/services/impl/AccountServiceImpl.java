package com.sandbox.firsttest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.firsttest.dto.AIRequestDto;
import com.sandbox.firsttest.dto.AIResponseDto;
import com.sandbox.firsttest.dto.UpdateAIRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.mapper.MapAIEntityToAIResponseDto;
import com.sandbox.firsttest.mapper.MapAIRequestDtoToAIEntity;
import com.sandbox.firsttest.mapper.MapUpdateAIRequestDtoToAIEntity;
import com.sandbox.firsttest.repository.impl.AccountRepositoryImpl;
import com.sandbox.firsttest.services.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	AccountRepositoryImpl accountRepositoryImpl;
	
	@Autowired
	MapAIEntityToAIResponseDto mapAIEntityToAIDto;
	@Autowired
	MapAIRequestDtoToAIEntity mapAIRequestDtoToAIEntity;
	@Autowired
	MapUpdateAIRequestDtoToAIEntity mapUpdateAIRequestDtoToAIEntity;

	@Override
	public AIResponseDto getAccountInformation(Integer id) {
		AccountInformationEntity accountInformationEntity = accountRepositoryImpl.getAccountInformation(id);
		return mapAIEntityToAIDto.map(accountInformationEntity);
	}

	@Override
	public AIResponseDto createAccountInformation(
			AIRequestDto accountInformationRequestDto) {
		AccountInformationEntity accountInformationEntityRequest = mapAIRequestDtoToAIEntity.map(accountInformationRequestDto);
		AccountInformationEntity accountInformationEntityResponse = accountRepositoryImpl.createAccountInformation(accountInformationEntityRequest);
		return mapAIEntityToAIDto.map(accountInformationEntityResponse);
	}

	@Override
	public void deleteAccountInformation(Integer id) {
		accountRepositoryImpl.deleteAccountInformation(id);
	}

	@Override
	public AIResponseDto updateAccountInformation(UpdateAIRequestDto updateAIRequestDto) {
		AccountInformationEntity accountInformationEntityRequest = mapUpdateAIRequestDtoToAIEntity.map(updateAIRequestDto);
		AccountInformationEntity accountInformationEntityResponse = accountRepositoryImpl.updateAccountInformation(accountInformationEntityRequest);
		return mapAIEntityToAIDto.map(accountInformationEntityResponse);
	}

}
