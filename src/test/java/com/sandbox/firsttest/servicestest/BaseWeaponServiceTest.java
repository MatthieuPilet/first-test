/**
 * 
 */
package com.sandbox.firsttest.servicestest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sandbox.firsttest.RunApplication;
import com.sandbox.firsttest.dto.BWResponseDto;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.mapper.MapBWEntityToBWResponseDtoImpl;
import com.sandbox.firsttest.repository.impl.BaseWeaponRepositoryImpl;
import com.sandbox.firsttest.services.impl.BaseWeaponServiceImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@ContextConfiguration(classes = RunApplication.class)
class BaseWeaponServiceTest {
	@InjectMocks
	BaseWeaponServiceImpl baseWeaponService;
	
	@Mock
	BaseWeaponRepositoryImpl baseWeaponRepositoryImpl;
	
	@Mock
	MapBWEntityToBWResponseDtoImpl mapBWEntityToBWResponseDto;
	
	@Test
    void getBaseWeaponOKTest() {
        Mockito.when(baseWeaponRepositoryImpl.getBaseWeapon(ArgumentMatchers.anyInt())).thenReturn(new BaseWeaponEntity());
        Mockito.when(mapBWEntityToBWResponseDto.map(ArgumentMatchers.any())).thenReturn(new BWResponseDto());
        BWResponseDto baseWeaponResponseDto = baseWeaponService.getBaseWeapon(99999999);
        assertNotNull(baseWeaponResponseDto);
    }
}
