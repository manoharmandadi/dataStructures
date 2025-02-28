package com.manosoft.datastructures.sort;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BubbleSortTest{
	private static Logger logger = LogManager.getLogger(BubbleSortTest.class);
	private Integer[] ascArr=new Integer[19];
	private Integer[] descArr = new Integer[19];
	private Integer[] randArr = new Integer[19];

	@Test
	public void TestSorted(){
		logger.info("Test Ascending Ordered Array Sorting");
		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		checkOrder(bubbleSort.sort(ascArr));
	}

	@Test
	public void TestDescSorted(){
		logger.info("Test Descending Ordered Array Sorting");
		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		checkOrder(bubbleSort.sort(descArr));
	}

	@Test
	public void TestRandSorted(){
		logger.info("Test Random Array Sorting");
		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		checkOrder(bubbleSort.sort(randArr));
	}

	public void checkOrder(Integer[] arr){
		int prev = 0;
		for(int curr:arr){
			Assertions.assertTrue(curr > prev);
		}
	}
	
	@BeforeEach
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
	
	@AfterEach
	public void tearDown(){
		ascArr = null;
		descArr = null;
	}
}
