package com.sandbox.firsttest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCharacterRequestDto {
	private Integer accountId;
	private String characterName;
}
