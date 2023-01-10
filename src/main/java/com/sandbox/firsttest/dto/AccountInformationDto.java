package com.sandbox.firsttest.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInformationDto {
	private BigDecimal accountId;
	private String accountUsername;
	private String accountPassword;
	private String accountEmail;
	private Integer accountAge;
	private Date accountBirthday;
	private Date accountSubscriptionDate;
}
