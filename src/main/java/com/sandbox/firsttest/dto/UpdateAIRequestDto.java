package com.sandbox.firsttest.dto;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This DTO is for update the account information
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UpdateAIRequestDto implements Serializable{
	/** UID */
	private static final long serialVersionUID = 1L;
	
	private BigInteger accountId;
	private String accountUsername;
	private String accountPassword;
	private String accountEmail;
}
