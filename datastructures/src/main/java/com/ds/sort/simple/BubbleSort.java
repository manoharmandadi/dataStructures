package com.ds.sort.simple;

import java.util.Comparator;

public class BubbleSort<E extends Comparable<E>> {
	private E[] a;
	public BubbleSort(E[] sample) {
		a = sample;
	}

	public String sort(){
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
		return "Comparision: "+comparisionCount+" ,Swappings: "+swapCount;
	}
	
	public String sort(Comparator<E> comparator){
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
		return "Comparision: "+comparisionCount+" ,Swappings: "+swapCount;
	}

}