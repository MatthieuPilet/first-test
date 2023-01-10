package com.sandbox.firsttest.repository.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandbox.firsttest.config.HibernateConf;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.repository.ITestRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class TestRepositoryImpl implements ITestRepository{

	@Autowired
	private final EntityManagerFactory entityManagerFactory;
	
	EntityManager em;
	
	public TestRepositoryImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory=entityManagerFactory;
		em = this.entityManagerFactory.createEntityManager();
	}
	
	@Override
	public AccountInformationEntity getAccountInformation(Integer id) {
		Session session = HibernateConf.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<AccountInformationEntity> cr = cb.createQuery(AccountInformationEntity.class);
		Root<AccountInformationEntity> root = cr.from(AccountInformationEntity.class);
		cr.select(root).where(cb.equal(root.get("accountId"), id));

		Query<AccountInformationEntity> query = session.createQuery(cr);
		return query.getSingleResult();
	}

}
