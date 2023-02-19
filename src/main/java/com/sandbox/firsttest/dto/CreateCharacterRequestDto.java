package com.sandbox.firsttest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * This DTO is to first creation of a character
 * 
 * @author Matthieu P
 * @version
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCharacterRequestDto {
	private Integer accountId;
	private String characterName;
}
