package com.sandbox.firsttest.services;

import com.sandbox.firsttest.dto.AIRequestDto;
import com.sandbox.firsttest.dto.AIResponseDto;
import com.sandbox.firsttest.dto.UpdateAIRequestDto;

public interface IAccountService {

	public AIResponseDto getAccountInformation(Integer id);
	public AIResponseDto createAccountInformation(AIRequestDto accountInformationRequestDto);
	public void deleteAccountInformation(Integer id);
	public AIResponseDto updateAccountInformation(UpdateAIRequestDto updateAIRequestDto);
}
