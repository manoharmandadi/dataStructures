package com.manosoft.datastructures.sort;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSortTest extends BaseSortTest {
	private static final Logger logger = LogManager.getLogger(BubbleSortTest.class);

	@Test
	public void TestSort(){
		displayTestData();

		BubbleSort<Integer> bubbleSort = new BubbleSort<>();
		logger.info("Random Array Sorting");
		bubbleSort.sort(randArr);
		logger.info("Ascending Array Sorting");
		bubbleSort.sort(ascArr);
		logger.info("Descending Array Sorting");
		bubbleSort.sort(descArr);

		assertSorted(randArr);
		assertSorted(ascArr);
		assertSorted(descArr);
		displayTestData();
	}

	@Test
	public void TestDescSorted(){
		logger.info("Test Descending Ordered Array Sorting");
		BubbleSort<Integer> bubbleSort = new BubbleSort<>();
		checkOrder(bubbleSort.sort(descArr));
	}

	@Test
	public void TestRandSorted(){
		logger.info("Test Random Array Sorting");
		BubbleSort<Integer> bubbleSort = new BubbleSort<>();
		checkOrder(bubbleSort.sort(randArr));
	}

	public void checkOrder(Integer[] arr){
		int prev = 0;
		for(int curr:arr){
			Assertions.assertTrue(curr > prev);
			prev = curr;
		}
	}
	
/*
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
*/
}
