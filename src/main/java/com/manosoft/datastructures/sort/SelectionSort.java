package com.manosoft.datastructures.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SelectionSort<E extends Comparable<E>> {

	private static final Logger logger = LogManager.getLogger(SelectionSort.class);

	public <E extends Comparable> E[] sort(E[] a){
		int comparisionCount = 0, swapCount = 0;
		int newLowIndex=0;
		for(int i=0; i<a.length;i++){
			newLowIndex = i;
			for(int j=i+1;j<a.length;j++){
				comparisionCount++;
				if(a[j].compareTo(a[newLowIndex]) < 0){
					newLowIndex = j;
				}
			}
			//Swap elements
			E temp = a[i];
			a[i] = a[newLowIndex];
			a[newLowIndex] = temp;
			swapCount++;
		}
		logger.info("Comparisions : "+comparisionCount+" , Swappings : "+swapCount);
		return a;

	}

	public <E extends Comparable> E[] sort(E[] a, Comparator<E> comparator){
		int comparisionCount = 0, swapCount = 0;
		int newLowIndex=0;
		for(int i=0; i<a.length;i++){
			newLowIndex = i;
			for(int j=i+1;j<a.length;j++){
				comparisionCount++;
				if(comparator.compare(a[j], a[newLowIndex]) < 0){
					newLowIndex = j;
				}
			}
			//Swap elements
			E temp = a[i];
			a[i] = a[newLowIndex];
			a[newLowIndex] = temp;
			swapCount++;
		}
		logger.info("Comparisions : "+comparisionCount+" , Swappings : "+swapCount);
		return a;

	}
	

}
