package com.sandbox.firsttest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.firsttest.dto.BWResponseDto;
import com.sandbox.firsttest.entity.BaseWeaponEntity;
import com.sandbox.firsttest.mapper.MapBWEntityToBWResponseDtoImpl;
import com.sandbox.firsttest.repository.impl.BaseWeaponRepositoryImpl;
import com.sandbox.firsttest.services.IBaseWeaponService;

@Service
public class BaseWeaponServiceImpl implements IBaseWeaponService{
	
	@Autowired
	BaseWeaponRepositoryImpl baseWeaponRepositoryImpl;
	
	@Autowired
	MapBWEntityToBWResponseDtoImpl mapBwEntityToBWDto;

	@Override
	public BWResponseDto getBaseWeapon(Integer baseWeaponId) {
		BaseWeaponEntity baseWeapondEntity = baseWeaponRepositoryImpl.getBaseWeapon(baseWeaponId);
		return mapBwEntityToBWDto.map(baseWeapondEntity);
	}

	@Override
	public List<BWResponseDto> getBaseWeapons() {
		List<BaseWeaponEntity> baseWeapondEntity = baseWeaponRepositoryImpl.getBaseWeapons();
		return baseWeapondEntity.stream().map(e -> mapBwEntityToBWDto.map(e)).toList();
	}

}
