package com.manosoft.datastructures.sort;


import org.junit.jupiter.api.*;

public class SelectionSortTest{
	
	Integer []a ;
	@BeforeEach
	public void setUp() throws Exception {
		a = new Integer[100];
		for(int i=0;i<100;i++){
			int random = (int)(Math.random()*100);
			a[i] = random;
		}
		
	}
	
	@Test
	public void testSort() {
		
		SelectionSort<Integer> sort = new SelectionSort();
		sort.sort(a);
		for(int i=1;i<100;i++){
			Assertions.assertTrue(a[i]>=a[i-1]);
		}
	}
	
	@AfterEach
	public void tearDown(){
		a = null;
	}
}
