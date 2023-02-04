/**
 * 
 */
package com.sandbox.firsttest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sandbox.firsttest.dto.AIRequestDto;
import com.sandbox.firsttest.dto.AIResponseDto;
import com.sandbox.firsttest.services.impl.AccountServiceImpl;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@SpringBootTest
@ContextConfiguration(classes = {
		AccountControllerTest.MockDependencies.class,
})
class AccountControllerTest {

	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountServiceImpl accountService;
	
	@Inject
    MockMvc mvc;
	
	@Test
    void getAccountInformationOKTest() {
		Mockito.when(accountService.getAccountInformation(ArgumentMatchers.anyInt())).thenReturn(new AIResponseDto());
		ResponseEntity<AIResponseDto> accountInformationResponseDto = accountController.getAccountInformation(ArgumentMatchers.any());
        assertNotNull(accountInformationResponseDto);
    }
	
	@Test
    void createAccountInformationOKTest() {
        Mockito.when(accountService.createAccountInformation(ArgumentMatchers.any())).thenReturn(new AIResponseDto());
		ResponseEntity<AIResponseDto> accountInformationResponseDto = accountController.createAccountInformation(ArgumentMatchers.any());
        assertNotNull(accountInformationResponseDto);
    }
	
	@Test
    void createAccountInformationKOTest() throws Exception {
		AIRequestDto accountInformationRequestDto = new AIRequestDto();
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new ObjectOutputStream(bos);
	    oos.writeObject(accountInformationRequestDto);
	    oos.flush();
	    byte [] data = bos.toByteArray();
	      
		mvc.perform(put("http://localhost:8080/account/createAccount").
                contentType(MediaType.APPLICATION_JSON).
                content(data)).
                andExpect(status().isBadRequest()).
                andReturn();
    }
	
	@Test
    void deleteAccountInformationOKTest() {
		Mockito.doNothing().when(accountService).deleteAccountInformation(ArgumentMatchers.anyInt());
		accountController.deleteAccountInformation(ArgumentMatchers.anyInt());
		Mockito.verify(accountService).deleteAccountInformation(ArgumentMatchers.anyInt());
    }
	
	@Test
    void deleteAccountInformationKOTest() throws MockitoException{
		Mockito.doThrow(new MockitoException("")).when(accountService).deleteAccountInformation(ArgumentMatchers.anyInt());
		ResponseEntity<String> response = accountController.deleteAccountInformation(9999999);
		assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }
	
	@Test
    void updateAccountInformationOKTest() throws MockitoException{
		Mockito.when(accountService.updateAccountInformation(ArgumentMatchers.any())).thenReturn(new AIResponseDto());
		ResponseEntity<AIResponseDto> accountInformationResponseDto = accountController.updateAccountInformation(ArgumentMatchers.any());
        assertNotNull(accountInformationResponseDto);
    }
	
	public static class MockDependencies {
        @Bean
        public MockMvc mvc() {
            return MockMvcBuilders.standaloneSetup(new AccountController()).build();
        }
    }
}
