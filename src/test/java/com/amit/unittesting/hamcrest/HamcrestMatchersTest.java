package com.amit.unittesting.hamcrest;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,45,15);
		
		assertThat(numbers, hasSize(3));
		
		assertThat(numbers, hasItem(45));
		
		assertThat(numbers, everyItem(greaterThan(10)));
		
		assertThat(numbers, everyItem(lessThan(100)));
		
		
		assertThat("ABCDE", containsString("BCD"));
		assertThat("ABCDE", startsWith("ABC"));
		assertThat("ABCDE", endsWith("DE"));
	}
	
}
