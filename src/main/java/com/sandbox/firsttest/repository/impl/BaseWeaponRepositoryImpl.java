package com.sandbox.firsttest.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sandbox.firsttest.config.HibernateConf;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.entity.BaseWeaponEntity_;
import com.sandbox.firsttest.repository.IBaseWeaponRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class BaseWeaponRepositoryImpl implements IBaseWeaponRepository {

	@Override
	public BaseWeaponEntity getBaseWeapon(Integer baseWeaponId) {
		Session session = HibernateConf.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<BaseWeaponEntity> query = cb.createQuery(BaseWeaponEntity.class);
		Root<BaseWeaponEntity> baseWeaponEntity = query.from(BaseWeaponEntity.class);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(baseWeaponEntity.get(BaseWeaponEntity_.BASE_WEAPOND_ID),baseWeaponId));
		
		query.multiselect(baseWeaponEntity.get(BaseWeaponEntity_.BASE_WEAPOND_ID),
				baseWeaponEntity.get(BaseWeaponEntity_.BASE_WEAPON_NAME),
				baseWeaponEntity.get(BaseWeaponEntity_.BASE_STAT_STRENGTH),
				baseWeaponEntity.get(BaseWeaponEntity_.BASE_STAT_AGILITY),
				baseWeaponEntity.get(BaseWeaponEntity_.BASE_STAT_INTELLIGENCE),
				baseWeaponEntity.get(BaseWeaponEntity_.BASE_STAT_WISDOM),
				baseWeaponEntity.get(BaseWeaponEntity_.BASE_STAT_STEALTH),
				baseWeaponEntity.get(BaseWeaponEntity_.BASE_STAT_VITALITY),
				baseWeaponEntity.get(BaseWeaponEntity_.BASE_STAT_ENERGY));
		query.where(predicates.stream().toArray(Predicate[]::new));
		
		BaseWeaponEntity baseWeaponEntityResult = session.createQuery(query).getSingleResult();
		session.close();
		return baseWeaponEntityResult;
	}



}
