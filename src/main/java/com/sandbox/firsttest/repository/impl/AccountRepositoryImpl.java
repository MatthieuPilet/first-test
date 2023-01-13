package com.sandbox.firsttest.repository.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandbox.firsttest.config.HibernateConf;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.repository.IAccountRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Repository
public class AccountRepositoryImpl implements IAccountRepository {

	@Autowired
	private final EntityManagerFactory entityManagerFactory;
	
	EntityManager em;
	
	public AccountRepositoryImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory=entityManagerFactory;
		em = this.entityManagerFactory.createEntityManager();
	}
	
	@Override
	public AccountInformationEntity getAccountInformation(Integer id) {
		Session session = HibernateConf.getSessionFactory().openSession();
		AccountInformationEntity accountInformationEntity = session.get(AccountInformationEntity.class, id);
		session.close();
		return accountInformationEntity;
	}

	@Override
	public AccountInformationEntity createAccountInformation(
			AccountInformationEntity accountInformationEntity) {
		Session session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(accountInformationEntity);
		session.flush();
		session.close();
		return accountInformationEntity;
	}

	@Override
	public void deleteAccountInformation(Integer id) {
		Session session = HibernateConf.getSessionFactory().openSession();
		AccountInformationEntity accountInformationEntity = session.get(AccountInformationEntity.class, id);
		session.beginTransaction();
		session.remove(accountInformationEntity);
		session.flush();
		session.close();
	}

}
