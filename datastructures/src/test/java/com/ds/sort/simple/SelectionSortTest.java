package com.ds.sort.simple;

import junit.framework.TestCase;

public class SelectionSortTest extends TestCase{
	
	Integer []a ;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		a = new Integer[100];
		for(int i=0;i<100;i++){
			int random = (int)(Math.random()*100);
			a[i] = random;
		}
		
	}
	
	public void testSort() {
		
		SelectionSort<Integer> sort = new SelectionSort<Integer>(a);
		sort.sort();
		for(int i=1;i<100;i++){
			assertTrue("Failed at "+i, a[i]>a[i-1]);
		}
	}
}
