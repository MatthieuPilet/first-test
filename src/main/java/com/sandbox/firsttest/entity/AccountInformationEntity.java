package com.sandbox.firsttest.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This entity id for all account information,
 * it contains a list of {@link CharacterEntity}
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ACCOUNT_INFORMATION",schema="PUBLIC")
public class AccountInformationEntity {
	/**
	 * The account ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "account_generator")
	@SequenceGenerator(name = "account_generator", sequenceName = "account_information_seq", allocationSize = 1)
	@Basic(optional = false)
	@Column(name="account_id",unique=true, nullable= false)
	private BigInteger accountId;
	
	/**
	 * The account username
	 */
	@Column(name="account_username", nullable= false)
	private String accountUsername;
	
	/**
	 * The account password
	 */
	@Column(name="account_password", nullable= false)
	private String accountPassword;
	
	/**
	 * The account email
	 */
	@Column(name="account_email", nullable= false)
	private String accountEmail;
	
	/**
	 * The account age
	 */
	@Column(name="account_age", nullable= false)
	private Integer accountAge;
	
	/**
	 * The account birthday
	 */
	@Column(name="account_birthday", nullable= false)
	private Date accountBirthday;
	
	/**
	 * The date of subsciption of the account
	 */
	@Column(name="account_subscription_date")
	@CreationTimestamp
	private Date accountSubscriptionDate;
	
	/**
	 * The list of {@link CharacterEntity} that link with the account 
	 */
	@OneToMany(mappedBy="accountInformationEntity", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<CharacterEntity> characters;
}
