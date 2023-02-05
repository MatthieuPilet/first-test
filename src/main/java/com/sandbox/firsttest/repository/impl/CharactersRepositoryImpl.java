package com.sandbox.firsttest.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sandbox.firsttest.config.HibernateConf;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.entity.AccountInformationEntity_;
import com.sandbox.firsttest.entity.CharacterEntity;
import com.sandbox.firsttest.entity.CharacterEntity_;
import com.sandbox.firsttest.repository.ICharactersRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class CharactersRepositoryImpl implements ICharactersRepository {

	@Override
	public List<CharacterEntity> getCharacters(Integer accountId) {
		Session session = HibernateConf.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CharacterEntity> query = cb.createQuery(CharacterEntity.class);
		Root<CharacterEntity> characterEntity = query.from(CharacterEntity.class);
		Join<CharacterEntity, AccountInformationEntity> accountEntityJoin = characterEntity.join(CharacterEntity_.ACCOUNT_INFORMATION_ENTITY, JoinType.INNER);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(accountEntityJoin.get(AccountInformationEntity_.ACCOUNT_ID),accountId));
		
		query.multiselect(characterEntity.get(CharacterEntity_.CHARACTER_ID),
				characterEntity.get(CharacterEntity_.ACCOUNT_INFORMATION_ENTITY),
				characterEntity.get(CharacterEntity_.BASE_WEAPON_ENTITY),
				characterEntity.get(CharacterEntity_.CHARACTERS_STATS_ENTITY),
				characterEntity.get(CharacterEntity_.CHARACTER_NAME),
				characterEntity.get(CharacterEntity_.CHARACTER_TITLE));
		query.where(predicates.stream().toArray(Predicate[]::new));
		
		List<CharacterEntity> charactersEntities = session.createQuery(query).getResultList();
		session.close();
		return charactersEntities;
	}
	
	@Override
	public CharacterEntity getCharacter(Integer characterId) {
		Session session = HibernateConf.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CharacterEntity> query = cb.createQuery(CharacterEntity.class);
		Root<CharacterEntity> characterEntity = query.from(CharacterEntity.class);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(characterEntity.get(CharacterEntity_.CHARACTER_ID),characterId));
		
		query.multiselect(characterEntity.get(CharacterEntity_.CHARACTER_ID),
				characterEntity.get(CharacterEntity_.ACCOUNT_INFORMATION_ENTITY),
				characterEntity.get(CharacterEntity_.BASE_WEAPON_ENTITY),
				characterEntity.get(CharacterEntity_.CHARACTERS_STATS_ENTITY),
				characterEntity.get(CharacterEntity_.CHARACTER_NAME),
				characterEntity.get(CharacterEntity_.CHARACTER_TITLE));
		query.where(predicates.stream().toArray(Predicate[]::new));
		
		CharacterEntity characterEntityResult = session.createQuery(query).getSingleResult();
		session.close();
		return characterEntityResult;
	}

	@Override
	public CharacterEntity createCharacter(CharacterEntity createCharacterRequestEntity) {
		Session session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(createCharacterRequestEntity);
		session.flush();
		session.close();
		return createCharacterRequestEntity;
	}

	@Override
	public CharacterEntity updateWeaponCharacter(CharacterEntity updateWeaponCharacterEntity) {
		Session session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(updateWeaponCharacterEntity);
		session.flush();
		session.close();
		return updateWeaponCharacterEntity;
	}

}
