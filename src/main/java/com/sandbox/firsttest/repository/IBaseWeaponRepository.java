package com.sandbox.firsttest.repository;

import com.sandbox.firsttest.entity.BaseWeaponEntity;

/**
 * This interface is for all operation about base weapon entity
 * 
 * @author Matthieu P
 * @version 1.0
 */
public interface IBaseWeaponRepository {
	
	/**
	 * Get Base Weapon by id
	 * 
	 * @param baseWeaponId the id of the base weapon
	 * @return {@link BaseWeaponEntity}
	 */
	public BaseWeaponEntity getBaseWeapon(Integer baseWeaponId);
}
