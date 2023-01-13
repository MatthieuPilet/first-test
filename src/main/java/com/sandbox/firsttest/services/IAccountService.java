package com.sandbox.firsttest.services;

import com.sandbox.firsttest.dto.AccountInformationRequestDto;
import com.sandbox.firsttest.dto.AccountInformationResponseDto;

public interface IAccountService {

	public AccountInformationResponseDto getAccountInformation(Integer id);
	public AccountInformationResponseDto createAccountInformation(AccountInformationRequestDto accountInformationRequestDto);
	public void deleteAccountInformation(Integer id);
}
