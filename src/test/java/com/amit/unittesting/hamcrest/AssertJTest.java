package com.amit.unittesting.hamcrest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertJTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,45,15);
		
		assertThat(numbers).hasSize(3)
		.contains(12,15)
		.allMatch(x -> x>10)
		.noneMatch(x -> x<0);
	}
	
}
