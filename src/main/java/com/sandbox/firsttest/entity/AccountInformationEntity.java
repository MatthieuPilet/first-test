package com.sandbox.firsttest.entity;

import java.math.BigInteger;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ACCOUNT_INFORMATION",schema="PUBLIC")
public class AccountInformationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "account_generator")
	@SequenceGenerator(name = "account_generator", sequenceName = "account_information_seq", allocationSize = 1)
	@Basic(optional = false)
	@Column(name="account_id",unique=true, nullable= false)
	private BigInteger accountId;
	
	@Column(name="account_username", nullable= false)
	private String accountUsername;
	
	@Column(name="account_password", nullable= false)
	private String accountPassword;
	
	@Column(name="account_email", nullable= false)
	private String accountEmail;
	
	@Column(name="account_age", nullable= false)
	private Integer accountAge;
	
	@Column(name="account_birthday", nullable= false)
	private Date accountBirthday;
	
	@Column(name="account_subscription_date")
	@CreationTimestamp
	private Date accountSubscriptionDate;
}
