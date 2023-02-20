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
import com.sandbox.firsttest.dto.AIRequestDto;
import com.sandbox.firsttest.dto.AIResponseDto;
import com.sandbox.firsttest.dto.UpdateAIRequestDto;
import com.sandbox.firsttest.entity.AccountInformationEntity;
import com.sandbox.firsttest.mapper.MapAIEntityToAIResponseDtoImpl;
import com.sandbox.firsttest.mapper.MapAIRequestDtoToAIEntityImpl;
import com.sandbox.firsttest.mapper.MapUpdateAIRequestDtoToAIEntityImpl;
import com.sandbox.firsttest.repository.impl.AccountRepositoryImpl;
import com.sandbox.firsttest.services.impl.AccountServiceImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@ContextConfiguration(classes = RunApplication.class)
class AccountServiceTest {
	@InjectMocks
	AccountServiceImpl accountService;
	
	@Mock
	AccountRepositoryImpl accountRepositoryImpl;
	
	@Mock
	MapAIEntityToAIResponseDtoImpl mapAIEntityToAIResponseDto;
	
	@Mock
	MapUpdateAIRequestDtoToAIEntityImpl mapUpdateAIRequestDtoToAIEntity;
	
	@Mock
	MapAIRequestDtoToAIEntityImpl mapAIRequestDtoToAIEntity;
	
	@Test
    void getAccountInformationOKTest() {
        Mockito.when(accountRepositoryImpl.getAccountInformation(ArgumentMatchers.anyInt())).thenReturn(new AccountInformationEntity());
        Mockito.when(mapAIEntityToAIResponseDto.map(ArgumentMatchers.any())).thenReturn(new AIResponseDto());
        AIResponseDto accountInformationResponseDto = accountService.getAccountInformation(99999999);
        assertNotNull(accountInformationResponseDto);
    }
	
	@Test
    void createAccountInformationOKTest() {
        Mockito.when(accountRepositoryImpl.createAccountInformation(ArgumentMatchers.any())).thenReturn(new AccountInformationEntity());
        Mockito.when(mapAIEntityToAIResponseDto.map(ArgumentMatchers.any())).thenReturn(new AIResponseDto());
        Mockito.when(mapAIRequestDtoToAIEntity.map(ArgumentMatchers.any())).thenReturn(new AccountInformationEntity());
        AIResponseDto accountInformationResponseDto = accountService.createAccountInformation(new AIRequestDto());
        assertNotNull(accountInformationResponseDto);
    }
	
	@Test
    void deleteAccountInformationOKTest() {
		Mockito.doNothing().when(accountRepositoryImpl).deleteAccountInformation(ArgumentMatchers.any());
        accountService.deleteAccountInformation(ArgumentMatchers.anyInt());
        Mockito.verify(accountRepositoryImpl).deleteAccountInformation(ArgumentMatchers.anyInt());
    }
	
	@Test
    void updateAccountInformationOKTest() {
		Mockito.when(mapAIEntityToAIResponseDto.map(ArgumentMatchers.any())).thenReturn(new AIResponseDto());
		Mockito.when(accountRepositoryImpl.updateAccountInformation(ArgumentMatchers.any())).thenReturn(new AccountInformationEntity());
		Mockito.when(mapUpdateAIRequestDtoToAIEntity.map(ArgumentMatchers.any())).thenReturn(new AccountInformationEntity());
		AIResponseDto aIResponseDto = accountService.updateAccountInformation(new UpdateAIRequestDto());
        assertNotNull(aIResponseDto);
    }
}
