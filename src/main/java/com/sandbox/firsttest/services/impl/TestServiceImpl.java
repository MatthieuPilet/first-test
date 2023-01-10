package com.sandbox.firsttest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.firsttest.dto.AccountInformationDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.mapper.MapAccountInformationEntityToAccountInformationDto;
import com.sandbox.firsttest.repository.impl.TestRepositoryImpl;
import com.sandbox.firsttest.services.ITestService;

@Service
public class TestServiceImpl implements ITestService{
	
	@Autowired
	TestRepositoryImpl testRepositoryImpl;
	
	@Autowired
	MapAccountInformationEntityToAccountInformationDto mapAccountInformationEntityToAccountInformationDto;

	@Override
	public AccountInformationDto getAccountInformation(Integer id) {
		AccountInformationEntity accountInformationEntity = testRepositoryImpl.getAccountInformation(id);
		return mapAccountInformationEntityToAccountInformationDto.map(accountInformationEntity);
	}

}
