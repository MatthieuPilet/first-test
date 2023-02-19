package com.sandbox.firsttest.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This DTO is to create account information
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class AIRequestDto implements Serializable{
	/** UID */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "UserName cannot be null!! Know you're name!")
	private String accountUsername;
	@NotNull(message = "Password null? You want to be hack?")
	@Size(min = 5, max = 30, message = "Your password must be between 5 and 30 characters")
	private String accountPassword;
	@Email(message = "We ask your mail!!! Your MAIL please!")
	private String accountEmail;
	@Min(1)
	private Integer accountAge;
	@Past(message = "You're not born? Please pick a good date!")
	private Date accountBirthday;
}
