package com.manosoft.datastructures.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class MergeSort {

    public static final Logger logger = LogManager.getLogger(MergeSort.class);

    static int visiting = 0;
    int swapping = 0;
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,-1,4, 8, 7};
        int[] sorted = sort(arr);
        logger.info("Visited: "+ visiting);
        logger.info(Arrays.toString(sorted));

    }

    public static int[] sort(int[] arr){
        int len = arr.length;
        if(arr.length==1){
            return arr;
        }

        int[] a = Arrays.copyOfRange(arr, 0, len/2);
        int[] b = Arrays.copyOfRange(arr, len/2, len);
        a = sort(a);
        b = sort(b);
        return merge(a, b);
    }

    public static int[] merge(int[] a, int[] b){

        logger.info("Merging Arrays: "+ Arrays.toString(a) +" with "+Arrays.toString(b));
        int aIdx = 0, bIdx = 0, aLen = a.length, bLen = b.length;
        int resLen = a.length + b.length;
        int c[] = new int[resLen];
        for(int i=0; i < resLen; i++){
            visiting++;
            if(aIdx >= aLen ){
                c[i] = b[bIdx];
                bIdx++;
            } else if(bIdx>=bLen){
                c[i] = a[aIdx];
                aIdx++;
            } else if( a[aIdx] < b[bIdx]){
                c[i] = a[aIdx];
                aIdx++;
            } else {
                c[i] = b[bIdx];
                bIdx++;
            }
        }
        logger.info("After Merge: "+ Arrays.toString(c));
        return c;
    }
}
