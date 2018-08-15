package com.ds.sort.simple;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
//		String[] sample = new String[100];
		Person[] sample = new Person[100];
		for(int i=0;i < 100 ;i++){
			int random = (int)(Math.random()*100);
//			sample[i] = random+"";
			sample[i] = new Person(random, random+""+i, i+""+random);
		}
		System.out.println("Before Sorting :");
		System.out.println(Arrays.toString(sample));
		BubbleSort<Person> sort = new BubbleSort<Person>(sample);
		Comparator<Person> fNameComparator = new FirstNameComparator();
//		System.out.println(sort.sort(fNameComparator));
		System.out.println(sort.sort());
		System.out.println(Arrays.toString(sample));
		
	}
	
}
