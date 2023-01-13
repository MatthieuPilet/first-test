package com.sandbox.firsttest.repository;

import com.sandbox.firsttest.entity.AccountInformationEntity;

public interface IAccountRepository {
	public AccountInformationEntity getAccountInformation(Integer id);
	public AccountInformationEntity createAccountInformation(AccountInformationEntity accountInformationEntity);
	public void deleteAccountInformation(Integer id);
}
