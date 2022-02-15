package com.amit.unittesting.bundles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amit.unittesting.business.SomeBusinessImpl;
import com.amit.unittesting.service.SomeDataService;
@ExtendWith(MockitoExtension.class)
class SomeBusinessTest {
	@InjectMocks
	SomeBusinessImpl business;
	@Mock
	SomeDataService someDataService;
	

	@Test
	void calculateSum_empty() {
		when(someDataService.retrieveAllData()).thenReturn(new int[] {});
		int actual=business.calculateSumUsingDataService();
		int expected = 0;
		
		assertEquals(expected, actual);
	}
	

	@Test
	void calculateSum_oneValue() {
		when(someDataService.retrieveAllData()).thenReturn(new int[] {1});
		int actual=business.calculateSumUsingDataService();
		int expected = 1;
		
		assertEquals(expected, actual);
	}
	
	@Test
	void calculateSumUsingDataService_basic() {
		when(someDataService.retrieveAllData()).thenReturn(new int[] {1,5,6});
		int actual=business.calculateSumUsingDataService();
		int expected = 12;
		
		assertEquals(expected, actual);
	}
	
	
}
