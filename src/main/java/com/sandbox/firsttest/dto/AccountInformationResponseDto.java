package com.sandbox.firsttest.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountInformationResponseDto {
	private BigDecimal accountId;
	private String accountUsername;
	private String accountPassword;
	private String accountEmail;
	private Integer accountAge;
	private Date accountBirthday;
	private Date accountSubscriptionDate;
}
