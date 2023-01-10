package com.sandbox.firsttest.entity;

import java.math.BigDecimal;
import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ACCOUNT_INFORMATION",schema="PUBLIC")
public class AccountInformationEntity {
	@Id
	@Column(name="account_id")
	private BigDecimal accountId;
	
	@Column(name="account_username")
	private String accountUsername;
	
	@Column(name="account_password")
	private String accountPassword;
	
	@Column(name="account_email")
	private String accountEmail;
	
	@Column(name="account_age")
	private Integer accountAge;
	
	@Column(name="account_birthday")
	private Date accountBirthday;
	
	@Column(name="account_subscription_date")
	private Date accountSubscriptionDate;
}
