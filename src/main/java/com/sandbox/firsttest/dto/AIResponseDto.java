package com.sandbox.firsttest.dto;

import java.math.BigInteger;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
