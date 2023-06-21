/**
 * 
 */
package com.sandbox.firsttest.mappertest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.dto.BWResponseDto;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.mapper.MapBWEntityToBWResponseDtoImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@ContextConfiguration(classes = RunApplication.class)
@SpringBootTest
class MapBWEntityToBWResponseDtoTest {

	@Autowired
	public MapBWEntityToBWResponseDtoImpl mapBWEntityToBWResponseDto;
	
	@Test
	void mapTest() {
		BaseWeaponEntity baseWeaponEntity = new BaseWeaponEntity();
		baseWeaponEntity.setBaseStatAgility(1);
		baseWeaponEntity.setBaseStatEnergy(1);
		baseWeaponEntity.setBaseStatIntelligence(1);
		baseWeaponEntity.setBaseStatStealth(1);
		baseWeaponEntity.setBaseStatStrength(1);
		baseWeaponEntity.setBaseStatVitality(1);
		baseWeaponEntity.setBaseStatWisdom(1);
		baseWeaponEntity.setBaseWeapondId(BigInteger.valueOf(1));
		baseWeaponEntity.setBaseWeaponName("TestName");
		BWResponseDto bWResponseDto = mapBWEntityToBWResponseDto.map(baseWeaponEntity);
		
		assertNotNull(bWResponseDto);
		assertEquals(1, bWResponseDto.getBaseStatAgility());
		assertEquals(1, bWResponseDto.getBaseStatEnergy());
		assertEquals(1, bWResponseDto.getBaseStatIntelligence());
		assertEquals(1, bWResponseDto.getBaseStatStealth());
		assertEquals(1, bWResponseDto.getBaseStatStrength());
		assertEquals(1, bWResponseDto.getBaseStatVitality());
		assertEquals(1, bWResponseDto.getBaseStatWisdom());
		assertEquals(BigInteger.valueOf(1), bWResponseDto.getBaseWeapondId());
		assertEquals("TestName", bWResponseDto.getBaseWeaponName());
		
	}
	

}
