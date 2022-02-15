package com.amit.unittesting.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.amit.unittesting.ItemController;
import com.amit.unittesting.business.ItemBusinessService;
import com.amit.unittesting.model.Item;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;

	@Test
	public void helloWorld_basic() throws Exception {

		// call "/hello-world"

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();

		String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

		// verify
		// assertEquals("Hello World", result.getResponse().getContentAsString());
	}

	@Test
	public void helloWorld_advance() throws Exception {

		// call "/hello-world"
		
		when(businessService.retrieveHardcodedItem()).thenReturn(new Item(1, "Ball", 10,100));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();

		String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"value\":0}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);

	}
	
	@Test
	public void helloWorld_advance_retrieveAllItems() throws Exception {

		// call "/hello-world"
		
		when(businessService.retrieveAllItems()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10)));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/all-items-from-db")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json("[{id:2,name:Item2,price:10}]")).andReturn();

		//String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);

	}
}
