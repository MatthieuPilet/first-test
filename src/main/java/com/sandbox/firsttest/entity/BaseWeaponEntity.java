package com.sandbox.firsttest.entity;

import java.math.BigInteger;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Table(name="BASE_WEAPON",schema="PUBLIC")
public class BaseWeaponEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "weapon_generator")
	@SequenceGenerator(name = "weapon_generator", sequenceName = "base_weapon_seq", allocationSize = 1)
	@Basic(optional = false)
	@Column(name="base_weapon_id",unique=true, nullable= false)
	private BigInteger baseWeapondId;
	
	@Column(name="base_weapon_name", nullable= false)
	private String baseWeaponName;
	
	@Column(name="base_stat_strength", nullable= false)
	private Integer baseStatStrength;
	
	@Column(name="base_stat_agility", nullable= false)
	private Integer baseStatAgility;
	
	@Column(name="base_stat_intelligence", nullable= false)
	private Integer baseStatIntelligence;
	
	@Column(name="base_stat_wisdom", nullable= false)
	private Integer baseStatWisdom;
	
	@Column(name="base_stat_stealth", nullable= false)
	private Integer baseStatStealth;
	
	@Column(name="base_stat_vitality", nullable= false)
	private Integer baseStatVitality;
	
	@Column(name="base_stat_energy", nullable= false)
	private Integer baseStatEnergy;
}
