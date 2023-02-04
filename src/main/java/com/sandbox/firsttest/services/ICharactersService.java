package com.sandbox.firsttest.services;

import java.util.List;

import com.sandbox.firsttest.dto.CharacterResponseDto;

public interface ICharactersService {

	public List<CharacterResponseDto> getCharacters(Integer accountId);
//	public AIResponseDto createAccountInformation(AIRequestDto accountInformationRequestDto);
//	public void deleteAccountInformation(Integer id);
//	public AIResponseDto updateAccountInformation(UpdateAIRequestDto updateAIRequestDto);
}
