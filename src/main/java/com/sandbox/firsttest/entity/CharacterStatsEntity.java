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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CHARACTERS_STATS",schema="PUBLIC")
public class CharacterStatsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "characters_stats_generator")
	@SequenceGenerator(name = "characters_stats_generator", sequenceName = "characters_stats_seq", allocationSize = 1)
	@Basic(optional = false)
	@Column(name="character_stats_id",unique=true, nullable= false)
	private BigInteger characterStatsId;
	
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
}
