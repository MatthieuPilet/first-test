package com.sandbox.firsttest.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This DTO contains all information of one character
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class CharacterResponseDto {
	private BigInteger characterId;
	private BigInteger accountId;
	private BigInteger baseWeaponId;
	private BigInteger characterStatsId;
	private String characterName;
	private String characterTitle;
	private Integer characterStrength;
	private Integer characterAgility;
	private Integer characterIntelligence;
	private Integer characterWisdom;
	private Integer characterStealth;
	private Integer characterVitality;
	private Integer characterEnergy;
	private Float characterLife;
}
