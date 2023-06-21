package com.sandbox.firsttest.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This DTO is the response of many account information operation, it contains lots of information of account
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class BWResponseDto {
	/**
	 * Base Weapon Id
	 */
	private BigInteger baseWeapondId;
	/**
	 * Base Weapon Name
	 */
	private String baseWeaponName;
	/**
	 * Strength
	 */
	private Integer baseStatStrength;
	/**
	 * Agility
	 */
	private Integer baseStatAgility; 
	/**
	 * Intelligence
	 */
	private Integer baseStatIntelligence;
	/**
	 * Wisdom
	 */
	private Integer baseStatWisdom; 
	/**
	 * Stealth
	 */
	private Integer baseStatStealth;
	/**
	 * Vitality
	 */
	private Integer baseStatVitality;
	/**
	 * Energy
	 */
	private Integer baseStatEnergy;
}
