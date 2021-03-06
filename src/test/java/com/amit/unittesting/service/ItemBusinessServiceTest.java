package com.amit.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amit.unittesting.business.ItemBusinessService;
import com.amit.unittesting.model.Item;
import com.amit.unittesting.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {
	@InjectMocks
	private ItemBusinessService business;

	@Mock
	private ItemRepository repository;
	
	@Test
	public void check() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10),
				new Item(3,"Item3",20,20)
				));
		List<Item> items= business.retrieveAllItems();
		
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
		
	}
}
