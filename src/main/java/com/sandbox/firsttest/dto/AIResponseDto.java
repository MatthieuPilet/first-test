package com.sandbox.firsttest.dto;

import java.math.BigInteger;
import java.util.Date;

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
public class AIResponseDto {
	private BigInteger accountId;
	private String accountUsername;
	private String accountPassword;
	private String accountEmail;
	private Integer accountAge;
	private Date accountBirthday;
	private Date accountSubscriptionDate;
}
