package com.sandbox.firsttest.repository;

import com.sandbox.firsttest.entity.AccountInformationEntity;

/**
 * This interface is for all operation about accountEntity
 * 
 * @author Matthieu P
 * @version 1.0
 */
public interface IAccountRepository {
	
	/**
	 * Get account information by id
	 * 
	 * @param id id of account information 
	 * @return {@link AccountInformationEntiy}
	 */
	public AccountInformationEntity getAccountInformation(Integer id);
	
	/**
	 * Create account information Entity
	 * 
	 * @param accountInformationEntity {@link AccountInformationEntiy}
	 * @return {@link AccountInformationEntiy}
	 */
	public AccountInformationEntity createAccountInformation(AccountInformationEntity accountInformationEntity);
	
	/**
	 * Delete account information by id
	 * 
	 * @param id the id of account information
	 */
	public void deleteAccountInformation(Integer id);
	
	/**
	 * Update account information 
	 * 
	 * @param accountInformationEntity {@link AccountInformationEntiy}
	 * @return {@link AccountInformationEntiy}
	 */
	public AccountInformationEntity updateAccountInformation(AccountInformationEntity accountInformationEntity);
}
