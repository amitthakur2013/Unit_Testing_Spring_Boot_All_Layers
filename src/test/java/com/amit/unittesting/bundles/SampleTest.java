package com.amit.unittesting.bundles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class SampleTest {
	List l=mock(List.class);
	
	@Test
	void test() {
		when(l.size()).thenReturn(4).thenReturn(9);
		assertEquals(4, l.size());
		assertEquals(9, l.size());
	}
	
	@Test
	void test_generic_parameter() {
		when(l.get(anyInt())).thenReturn(4);
		assertEquals(4, l.get(8));
		
	}
	
	@Test
	void test_add_parameter() {
		l.add("something!");
		
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		
		verify(l).add(captor.capture());
		assertEquals("something!", captor.getValue());
		
	}
	
	@Test
	void test_add_multiple_parameter() {
		l.add("something!");
		l.add("something2!");
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		
		verify(l,times(2)).add(captor.capture());
		List<String> ll=captor.getAllValues();
		assertEquals("something!", ll.get(0));
		assertEquals("something2!", ll.get(1));
		
	}

}
