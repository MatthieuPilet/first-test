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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This Entity is for the stats of the {@link CharacterEntity}
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="CHARACTERS_STATS",schema="PUBLIC")
public class CharacterStatsEntity {
	
	/**
	 * The id of the stats of the character
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "characters_stats_generator")
	@SequenceGenerator(name = "characters_stats_generator", sequenceName = "characters_stats_seq", allocationSize = 1)
	@Basic(optional = false)
	@Column(name="character_stats_id",unique=true, nullable= false)
	private BigInteger characterStatsId;
	
	/**
	 * Strength of the character
	 */
	@Column(name="character_strength", nullable= false)
	private Integer characterStrength;
	
	/**
	 * Agility of the character
	 */
	@Column(name="character_agility", nullable= false)
	private Integer characterAgility;
	
	/**
	 * Intelligence of the character
	 */
	@Column(name="character_intelligence", nullable= false)
	private Integer characterIntelligence;
	
	/**
	 * Wisdom of the character
	 */
	@Column(name="character_wisdom", nullable= false)
	private Integer characterWisdom;
	
	/**
	 * Stealth of the character
	 */
	@Column(name="character_stealth", nullable= false)
	private Integer characterStealth;
	
	/**
	 * Vitality of the character
	 */
	@Column(name="character_vitality", nullable= false)
	private Integer characterVitality;
	
	/**
	 * Energy of the character
	 */
	@Column(name="character_energy", nullable= false)
	private Integer characterEnergy;
	
	/**
	 * Life of the character
	 */
	@Column(name="character_life", nullable= false)
	private Float characterLife;
}
