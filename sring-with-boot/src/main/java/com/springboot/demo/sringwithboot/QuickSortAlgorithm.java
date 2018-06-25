package com.springboot.demo.sringwithboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

@Primary
public class QuickSortAlgorithm implements Sorting{

	@Override
	public int[] sort(int[] numbers, int numberToFind) {
		
		return numbers;
	}

}
