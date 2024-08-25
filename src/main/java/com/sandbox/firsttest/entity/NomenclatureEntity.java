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

/**
 * This entity is for Nomenclature table, this table contain all the referential for different things,
 * category, rarity, etc etc...
 * 
 * @author Matthieu P
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="NOMENCLATURE",schema="PUBLIC")
public class NomenclatureEntity {
	/**
	 * The id of the character
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "nomenclature_generator")
	@SequenceGenerator(name = "nomenclature_generator", sequenceName = "nomenclature_seq", allocationSize = 1)
	@Basic(optional = false)
	@Column(name="nomenclature_id",unique=true, nullable= false)
	private BigInteger nomenclatureId;
	
	/**
	 * The account of the character
	 */
	@Column(name="nomenclature_code", nullable= false)
	private String nomenclatureCode;
	
	/**
	 * The account of the character
	 */
	@Column(name="nomenclature_category", nullable= false)
	private String nomenclatureCategory;
	
	/**
	 * The account of the character
	 */
	@Column(name="nomenclature_label", nullable= false)
	private String nomenclatureLabel;
	
	
}
