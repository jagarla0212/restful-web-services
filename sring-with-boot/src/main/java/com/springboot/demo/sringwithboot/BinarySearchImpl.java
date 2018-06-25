package com.springboot.demo.sringwithboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	@Autowired
	public Sorting sorting ;

	/*public BinarySearchImpl(Sorting sorting) {
		super();
		this.sorting = sorting;
	}
	*/
	


	/*public void setSorting(Sorting sorting) {
		this.sorting = sorting;
	}
*/



	public int binarySearch(int[] numbers, int number) {
		int[] result = sorting.sort(numbers, number);
		System.out.println(sorting);
		return 5;
		
	}
	
}
