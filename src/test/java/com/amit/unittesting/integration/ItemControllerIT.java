package com.amit.unittesting.integration;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

import com.amit.unittesting.model.Item;
import com.amit.unittesting.repository.ItemRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private ItemRepository itemRepository;
	
	@Test
	public void contextLoads() throws JSONException {
		String resp=this.restTemplate.getForObject("/all-items-from-db", String.class);
		System.out.println(resp.toString());
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1001,"Item2",10,10),
				new Item(1002,"Item3",20,20)
				));
		JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]", resp, false);
			}
	
}
