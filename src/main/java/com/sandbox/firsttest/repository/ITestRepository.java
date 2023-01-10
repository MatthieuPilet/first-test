package com.sandbox.firsttest.repository;

import com.sandbox.firsttest.entity.AccountInformationEntity;

public interface ITestRepository {
	public AccountInformationEntity getAccountInformation(Integer id);
}
