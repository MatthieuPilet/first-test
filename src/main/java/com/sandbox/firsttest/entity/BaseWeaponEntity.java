package com.sandbox.firsttest.entity;

import java.math.BigInteger;
import java.util.List;

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
 * This Entity is for the Base weapon of all characters
 * It contains the list of {@link CharacterEntity} witch have the weapon
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="BASE_WEAPON",schema="PUBLIC")
public class BaseWeaponEntity {
	/**
	 * The Id of base weapon
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "weapon_generator")
	@SequenceGenerator(name = "weapon_generator", sequenceName = "base_weapon_seq", allocationSize = 1)
	@Basic(optional = false)
	@Column(name="base_weapon_id",unique=true, nullable= false)
	private BigInteger baseWeapondId;
	
	/**
	 * The name of base weapon
	 */
	@Column(name="base_weapon_name", nullable= false)
	private String baseWeaponName;
	
	/**
	 * The strength of base weapon
	 */
	@Column(name="base_stat_strength", nullable= false)
	private Integer baseStatStrength;
	
	/**
	 * The agility of base weapon
	 */
	@Column(name="base_stat_agility", nullable= false)
	private Integer baseStatAgility;
	
	/**
	 * The intelligence of base weapon
	 */
	@Column(name="base_stat_intelligence", nullable= false)
	private Integer baseStatIntelligence;
	
	/**
	 * The wisdom of base weapon
	 */
	@Column(name="base_stat_wisdom", nullable= false)
	private Integer baseStatWisdom;
	
	/**
	 * The stealth of base weapon
	 */
	@Column(name="base_stat_stealth", nullable= false)
	private Integer baseStatStealth;
	
	/**
	 * The vitality of base weapon
	 */
	@Column(name="base_stat_vitality", nullable= false)
	private Integer baseStatVitality;
	
	/**
	 * The energy of base weapon
	 */
	@Column(name="base_stat_energy", nullable= false)
	private Integer baseStatEnergy;
	
	/**
	 * The list of {@link CharacterEntity} witch have the weapon
	 */
	@OneToMany(mappedBy="baseWeaponEntity", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<CharacterEntity> characters;

	/**
	 * The constructor for getBaseWeapon
	 * 
	 * @param baseWeapondId
	 * @param baseWeaponName
	 * @param baseStatStrength
	 * @param baseStatAgility
	 * @param baseStatIntelligence
	 * @param baseStatWisdom
	 * @param baseStatStealth
	 * @param baseStatVitality
	 * @param baseStatEnergy
	 */
	public BaseWeaponEntity(BigInteger baseWeapondId, String baseWeaponName, Integer baseStatStrength,
			Integer baseStatAgility, Integer baseStatIntelligence, Integer baseStatWisdom, Integer baseStatStealth,
			Integer baseStatVitality, Integer baseStatEnergy) {
		super();
		this.baseWeapondId = baseWeapondId;
		this.baseWeaponName = baseWeaponName;
		this.baseStatStrength = baseStatStrength;
		this.baseStatAgility = baseStatAgility;
		this.baseStatIntelligence = baseStatIntelligence;
		this.baseStatWisdom = baseStatWisdom;
		this.baseStatStealth = baseStatStealth;
		this.baseStatVitality = baseStatVitality;
		this.baseStatEnergy = baseStatEnergy;
	}
}
