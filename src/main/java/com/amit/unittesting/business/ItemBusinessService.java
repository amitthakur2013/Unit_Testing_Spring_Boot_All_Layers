package com.amit.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.unittesting.model.Item;
import com.amit.unittesting.repository.ItemRepository;

@Service
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item retrieveHardcodedItem() {
		return new Item(1, "Ball", 10,100);
	}
	
	public List<Item> retrieveAllItems() {
		List<Item> items = this.itemRepository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getPrice()*item.getQuantity());
		}
		
		return this.itemRepository.findAll();
	}
	

}
