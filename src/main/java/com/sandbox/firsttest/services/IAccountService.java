package com.sandbox.firsttest.services;

import org.springframework.transaction.annotation.Transactional;

import com.sandbox.firsttest.dto.AIRequestDto;
import com.sandbox.firsttest.dto.AIResponseDto;
import com.sandbox.firsttest.dto.UpdateAIRequestDto;

/**
 * This interface is for all functionnal service about accountInformation
 * 
 * @author Matthieu P
 * @version 1.0
 */
public interface IAccountService {

	/**
	 * Get account information By Id
	 * 
	 * @param id the id of account 
	 * @return {@link AIResponseDto}
	 */
	@Transactional(readOnly = true)
	public AIResponseDto getAccountInformation(Integer id);
	
	/**
	 * Create an account
	 * 
	 * @param accountInformationRequestDto {@link AIRequestDto}
	 * @return {@link AIResponseDto}
	 */
	@Transactional
	public AIResponseDto createAccountInformation(AIRequestDto accountInformationRequestDto);
	
	/**
	 * Delete an account by ID
	 * 
	 * @param id the id of the account
	 */
	@Transactional
	public void deleteAccountInformation(Integer id);
	
	/**
	 * Update an account
	 * 
	 * @param updateAIRequestDto {@link UpdateAIRequestDto}
	 * @return {@link AIResponseDto}
	 */
	@Transactional
	public AIResponseDto updateAccountInformation(UpdateAIRequestDto updateAIRequestDto);
}
