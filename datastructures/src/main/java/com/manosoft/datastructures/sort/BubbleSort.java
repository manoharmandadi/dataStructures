package com.manosoft.datastructures.sort;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
This class sorts the given elements as per Natural Sorting order of the elements
*/
public class BubbleSort<E extends Comparable<E>>{
	
	private static Logger logger = LoggerFactory.getLogger(BubbleSort.class);
	private E[] a;
	public BubbleSort(E[] sample) {
		a = sample;
	}

	public void sort(){
		E temp;
		int comparisionCount = 0, swapCount = 0;
		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				comparisionCount++;
				if((a[j].compareTo(a[j+1])>0)){
					swapCount++;
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		logger.debug("Comparision: "+comparisionCount+" ,Swappings: "+swapCount);
	}
	
	/**
	* Add Method comments for Sort Method
	*/
	public void sort(Comparator<E> comparator){
		E temp;
		int comparisionCount = 0, swapCount = 0;
		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				comparisionCount++;
				if(comparator.compare(a[j], a[j+1])>0){
					swapCount++;
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		logger.debug("Comparision: "+comparisionCount+" ,Swappings: "+swapCount);
	}

	public E[] getSortedArray(){
		return a;
	}
}
