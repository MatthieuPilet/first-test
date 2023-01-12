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

import com.sandbox.firsttest.dto.AccountInformationRequestDto;
import com.sandbox.firsttest.dto.AccountInformationResponseDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.mapper.MapAccountInformationEntityToAccountInformationResponseDto;
import com.sandbox.firsttest.mapper.MapAccountInformationRequestDtoToAccountInformationEntity;
import com.sandbox.firsttest.repository.impl.AccountRepositoryImpl;
import com.sandbox.firsttest.services.impl.AccountServiceImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
class AccountServiceTest {
	@InjectMocks
	AccountServiceImpl accountService;
	
	@Mock
	AccountRepositoryImpl accountRepositoryImpl;
	
	@Mock
	MapAccountInformationEntityToAccountInformationResponseDto mapAccountInformationEntityToAccountInformationResponseDto;
	
	@Mock
	MapAccountInformationRequestDtoToAccountInformationEntity mapAccountInformationRequestDtoToAccountInformationEntity;
	
	@Test
    void getAccountInformationOKTest() {
        Mockito.when(accountRepositoryImpl.getAccountInformation(ArgumentMatchers.anyInt())).thenReturn(new AccountInformationEntity());
        Mockito.when(mapAccountInformationEntityToAccountInformationResponseDto.map(ArgumentMatchers.any())).thenReturn(new AccountInformationResponseDto());
        AccountInformationResponseDto accountInformationResponseDto = accountService.getAccountInformation(99999999);
        assertNotNull(accountInformationResponseDto);
    }
	
	@Test
    void createAccountInformationOKTest() {
        Mockito.when(accountRepositoryImpl.createAccountInformation(ArgumentMatchers.any())).thenReturn(new AccountInformationEntity());
        Mockito.when(mapAccountInformationEntityToAccountInformationResponseDto.map(ArgumentMatchers.any())).thenReturn(new AccountInformationResponseDto());
        Mockito.when(mapAccountInformationRequestDtoToAccountInformationEntity.map(ArgumentMatchers.any())).thenReturn(new AccountInformationEntity());
        AccountInformationResponseDto accountInformationResponseDto = accountService.createAccountInformation(new AccountInformationRequestDto());
        assertNotNull(accountInformationResponseDto);
    }
}
