package com.sandbox.firsttest.entity;

import java.math.BigInteger;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CHARACTERS",schema="PUBLIC")
public class CharacterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "characters_generator")
	@SequenceGenerator(name = "characters_generator", sequenceName = "characters_seq", allocationSize = 1)
	@Basic(optional = false)
	@Column(name="character_id",unique=true, nullable= false)
	private BigInteger characterId;
	
	@ManyToOne
	@JoinColumn(name="account_id", nullable= false)
	private AccountInformationEntity accountInformationEntity;
	
	@OneToOne
	@JoinColumn(name="base_weapon_id", nullable= false)
	private BaseWeaponEntity baseWeaponEntity;
	
	@Column(name="character_name", nullable= false)
	private String characterName;
	
	@Column(name="character_title", nullable= false)
	private String characterTitle;
	
	@Column(name="character_strength", nullable= false)
	private Integer characterStrength;
	
	@Column(name="character_agility", nullable= false)
	private Integer characterAgility;
	
	@Column(name="character_intelligence", nullable= false)
	private Integer characterIntelligence;
	
	@Column(name="character_wisdom", nullable= false)
	private Integer characterWisdom;
	
	@Column(name="character_stealth", nullable= false)
	private Integer characterStealth;
	
	@Column(name="character_vitality", nullable= false)
	private Integer characterVitality;
	
	@Column(name="character_energy", nullable= false)
	private Integer characterEnergy;
	
	@Column(name="character_life", nullable= false)
	private Float characterLife;

	public CharacterEntity(Integer characterId, Integer accountInformationId,
			Integer baseWeaponId, String characterName, String characterTitle, Integer characterStrength,
			Integer characterAgility, Integer characterIntelligence, Integer characterWisdom, Integer characterStealth,
			Integer characterVitality, Integer characterEnergy, Float characterLife) {
		super();
		this.characterId = BigInteger.valueOf(characterId);
		this.accountInformationEntity = new AccountInformationEntity();
		this.accountInformationEntity.setAccountId(BigInteger.valueOf(accountInformationId)); 
		this.baseWeaponEntity = new BaseWeaponEntity();
		this.baseWeaponEntity.setBaseWeapondId(BigInteger.valueOf(baseWeaponId));
		this.characterName = characterName;
		this.characterTitle = characterTitle;
		this.characterStrength = characterStrength;
		this.characterAgility = characterAgility;
		this.characterIntelligence = characterIntelligence;
		this.characterWisdom = characterWisdom;
		this.characterStealth = characterStealth;
		this.characterVitality = characterVitality;
		this.characterEnergy = characterEnergy;
		this.characterLife = characterLife;
	}
	
	
}
