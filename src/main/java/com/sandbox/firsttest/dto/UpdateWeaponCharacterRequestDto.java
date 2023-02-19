package com.sandbox.firsttest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * This DTO is to update the base weapon of a character
 * 
 * @author Matthieu P
 * @version
 */
@Getter
@NoArgsConstructor
public class UpdateWeaponCharacterRequestDto {
	private Integer baseWeaponId;
	private Integer characterId;
}
