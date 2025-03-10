package com.manosoft.datastructures.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

/**
This class sorts the given elements as per Natural Sorting order of the elements
*/
public class BubbleSort<E extends Comparable<E>>{
	
	private static Logger logger = LogManager.getLogger(BubbleSort.class);

	public <E extends Comparable> E[] sort(E[] a){
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
		return a;
	}
	
	/**
	* Add Method comments for Sort Method
	*/
	public <E> E[] sort(E[] a, Comparator<E> comparator){
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
		return a;
	}

}
