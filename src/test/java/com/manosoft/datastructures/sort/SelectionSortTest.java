package com.manosoft.datastructures.sort;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

public class SelectionSortTest extends  BaseSortTest {

	private static final Logger logger = LogManager.getLogger(SelectionSort.class);
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

}
