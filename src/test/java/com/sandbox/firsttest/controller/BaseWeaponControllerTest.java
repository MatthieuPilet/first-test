/**
 * 
 */
package com.sandbox.firsttest.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sandbox.firsttest.dto.BWResponseDto;
import com.sandbox.firsttest.services.impl.BaseWeaponServiceImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
class BaseWeaponControllerTest {

	@InjectMocks
	BaseWeaponController baseWeaponController;
	
	@Mock
	BaseWeaponServiceImpl baseWeaponService;
	
	@Test
    void getBaseWeaponOKTest() {
		Mockito.when(baseWeaponService.getBaseWeapon(ArgumentMatchers.anyInt())).thenReturn(new BWResponseDto());
		ResponseEntity<BWResponseDto> baseWeaponResponseDto = baseWeaponController.getBaseWeapon(ArgumentMatchers.any());
        assertNotNull(baseWeaponResponseDto);
    }
	
	@Test
    void getBaseWeaponsOKTest() {
		Mockito.when(baseWeaponService.getBaseWeapons()).thenReturn(new ArrayList<>());
		ResponseEntity<List<BWResponseDto>> baseWeaponResponseDto = baseWeaponController.getBaseWeapons();
        assertNotNull(baseWeaponResponseDto);
    }
}
