package com.amit.unittesting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.unittesting.business.ItemBusinessService;
import com.amit.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService itemService;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10,100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item dummyItem_fromBusinessService() {
		return itemService.retrieveHardcodedItem();
	}
	
	@GetMapping("/all-items-from-db")
	public List<Item> dummyItem_fromBusinessServiceFindAll() {
		return itemService.retrieveAllItems();
	}
}
