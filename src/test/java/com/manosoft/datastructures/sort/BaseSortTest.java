package com.manosoft.datastructures.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public abstract class BaseSortTest {

    private static final Logger logger = LogManager.getLogger(BaseSortTest.class);

    protected Integer[] ascArr=new Integer[19];
    protected Integer[] descArr = new Integer[19];
    protected Integer[] randArr = new Integer[19];

    @BeforeEach
    public void setUpTestData(){
        for(int i=0; i<19; i++){
            randArr[i] = (int)(Math.random()*100);
            ascArr[i] = i;
            descArr[18-i] = i;
            if(i%5 ==0 ){
                ascArr[i] = (int)(Math.random()*100);
                descArr[18-i] = (int)(Math.random()*100);
            }
        }
    }

    @AfterEach
    public void clearTestData(){
        randArr = null;
        ascArr = null;
        descArr = null;
    }

    protected void displayTestData(){
        logger.debug("Random Array.");
        logger.debug(Arrays.toString(randArr));
        logger.debug("Almost Sorted Array");
        logger.debug(Arrays.toString(ascArr));
        logger.debug("Reverse Sorted Array");
        logger.debug(Arrays.toString(descArr));
    }

    public void assertSorted(Integer[] arr){
        int prev = 0;
        for(int curr:arr){
            Assertions.assertTrue(curr >= prev);
            prev = curr;
        }
    }
}
