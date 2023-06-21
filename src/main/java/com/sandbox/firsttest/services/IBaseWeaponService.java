package com.sandbox.firsttest.services;

import com.sandbox.firsttest.dto.BWResponseDto;

/**
 * This interface is for all functionnal service about baseWeapon
 * 
 * @author Matthieu P
 * @version 1.0
 */
public interface IBaseWeaponService {

	/**
	 * The purpose of this method is to get 1 base weapon
	 * 
	 * @param baseWeaponId
	 * @return {@link BWResponseDto}
	 */
	public BWResponseDto getBaseWeapon(Integer baseWeaponId);
}
