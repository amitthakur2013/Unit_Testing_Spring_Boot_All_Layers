package com.amit.unittesting.hamcrest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.contains;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void learning() {
		String response="[{\"id\":1000,\"name\":\"Pencil\"},{\"id\":1001,\"name\":\"Pen\"}]";
		
		DocumentContext context= JsonPath.parse(response);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(2);
		
		List<Integer> ids=context.read("$..id");
		
		assertThat(ids).containsExactly(1000,1001);
		System.out.println(context.read("$.[1]").toString());

		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name == 'Pen']").toString());
	}

}
