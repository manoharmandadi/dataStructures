package com.manosoft.datastructures.sort;

public class SelectionSort<E extends Comparable<E>> {

	private E[] a;
	
	public SelectionSort(E[] a){
		this.a = a; 
	}
	
	public String sort(){
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
		return "Comparisions : "+comparisionCount+" , Swappings : "+swapCount;
	}
	

}
