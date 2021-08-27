package com.manosoft.datastructures.sort;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BubbleSortTest{
	private static Logger logger = LoggerFactory.getLogger(BubbleSortTest.class);
	private Integer[] ascArr=new Integer[19];
	private Integer[] descArr = new Integer[19];
	private Integer[] randArr = new Integer[19];

	@Test
	public void TestSorted(){
		logger.info("Test Ascending Ordered Array Sorting");
		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>(ascArr);
		bubbleSort.sort();
		checkOrder(bubbleSort.getSortedArray());
	}

	@Test
	public void TestDescSorted(){
		logger.info("Test Descending Ordered Array Sorting");
		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>(descArr);
		bubbleSort.sort();
		checkOrder(bubbleSort.getSortedArray());
	}

	@Test
	public void TestRandSorted(){
		logger.info("Test Random Array Sorting");
		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>(randArr);
		bubbleSort.sort();
		checkOrder(bubbleSort.getSortedArray());
	}

	public void checkOrder(Integer[] arr){
		int prev = arr[0];
		int curr = 0;
		for(int i = 1; i < arr.length; i++){
		    curr = arr[i];
			assertTrue(curr > prev);
		}
	}
	
	@Before
	public void setUp(){
		for(int i=0; i<19;i++){
			ascArr[i] = i;
			descArr[18-i] = i;
			if(i%2 ==0){
				randArr[i] = i;
			}else{
				randArr[18-i]=i;
			}
			
		}
	}
	
	@After
	public void tearDown(){
		ascArr = null;
		descArr = null;
	}
}
