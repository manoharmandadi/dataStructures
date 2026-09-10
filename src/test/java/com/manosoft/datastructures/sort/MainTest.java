package com.manosoft.datastructures.sort;

import java.util.Arrays;
import java.util.Comparator;

import com.manosoft.datastructures.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainTest {
	public static final Logger logger = LogManager.getLogger(MainTest.class);
	public static void main(String[] args) {
//		String[] sample = new String[100];
		Person[] sample = new Person[100];
		for(int i=0;i < 100 ;i++){
			int random = (int)(Math.random()*100);
//			sample[i] = random+"";
			sample[i] = new Person(random, random+""+i, i+""+random);
		}
		logger.info("Before Sorting :");
		logger.info(Arrays.toString(sample));
		BubbleSort<Person> sort = new BubbleSort();
		Comparator<Person> fNameComparator = new FirstNameComparator();
		sample = sort.sort(sample, fNameComparator);
		logger.info(Arrays.toString(sample));
		
	}
	
}
