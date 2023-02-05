package com.sandbox.firsttest.entity;

import java.math.BigInteger;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_id", nullable= false)
	private AccountInformationEntity accountInformationEntity;
	
	@OneToOne
	@JoinColumn(name="base_weapon_id")
	private BaseWeaponEntity baseWeaponEntity;
	
	@OneToOne
	@JoinColumn(name="character_stats_id")
	private CharacterStatsEntity charactersStatsEntity;
	
	@Column(name="character_name", nullable= false)
	private String characterName;
	
	@Column(name="character_title", nullable= true)
	private String characterTitle;

	public CharacterEntity(Integer characterId, Integer accountInformationId,
			Integer baseWeaponId,Integer charactersStatsId, String characterName, String characterTitle) {
		super();
		this.characterId = BigInteger.valueOf(characterId);
		this.accountInformationEntity = new AccountInformationEntity();
		this.accountInformationEntity.setAccountId(BigInteger.valueOf(accountInformationId)); 
		this.baseWeaponEntity = new BaseWeaponEntity();
		this.baseWeaponEntity.setBaseWeapondId(BigInteger.valueOf(baseWeaponId));
		this.charactersStatsEntity = new CharacterStatsEntity();
		this.charactersStatsEntity.setCharacterStatsId(BigInteger.valueOf(charactersStatsId));
		this.characterName = characterName;
		this.characterTitle = characterTitle;
	}
	
	
}
