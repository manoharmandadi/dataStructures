package com.manosoft.datastructures.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TowerOfHanoi {

	public static final Logger logger = LogManager.getLogger(TowerOfHanoi.class);

	public static void main(String[] args) {
		int[] arr1 = {5,4,3,2,1};
		int[] arr2 = new int[5];
		int[] arr3 = new int[5];
		
		
		
	}
	
	public static void shift(int[] arr1, int[] arr2, int[] arr3){
		for(int i = arr1.length ; i>0 ; i--){
			int currVal = arr1[i];
			logger.info("Moving :" +currVal);
			
			for(int j=0; j<i;j++){
				if(false){
					
				}
				
			}
		}
	}
	
	public static void reArrange(int currVal, int[] arr1, int[] arr2, int[] arr3){
		
	}
	
}
