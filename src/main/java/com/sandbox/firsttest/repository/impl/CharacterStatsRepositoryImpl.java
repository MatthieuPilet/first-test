package com.sandbox.firsttest.repository.impl;

import java.math.BigInteger;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sandbox.firsttest.config.HibernateConf;
import com.sandbox.firsttest.entity.CharacterStatsEntity;
import com.sandbox.firsttest.repository.ICharacterStatsRepository;

@Repository
public class CharacterStatsRepositoryImpl implements ICharacterStatsRepository {

	@Override
	public CharacterStatsEntity getCharacterStats(BigInteger characterStatsId) {
		Session session = HibernateConf.getSessionFactory().openSession();
		CharacterStatsEntity characterStatsEntity = session.get(CharacterStatsEntity.class, characterStatsId);
		session.close();
		return characterStatsEntity;
	}
	
	@Override
	public CharacterStatsEntity updateCharacterStats(CharacterStatsEntity characterStatsEntity) {
		Session session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(characterStatsEntity);
		session.flush();
		session.close();
		return characterStatsEntity;
	}


}
