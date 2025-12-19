package com.manosoft.datastructures.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {

    static List<String> anagrams = new ArrayList<>();
    static long allCombinations = 0;
    public static void main(String[] args) {
        String input = "AZYTHROMSDPICQX"; //15
        // "FORTYSIXMEN"; 11
        createAnagrams(-1, new char[input.length()], input.toCharArray());
        System.out.println("All Combinations: "+allCombinations);
    }

    private static void createAnagrams(int idx, char[] preArr, char[] curr) {
        if(curr.length==1){
            preArr[preArr.length-1] = curr[0];
            String result = new String(preArr);
            System.out.println(result);
            allCombinations++;
            return ;
        }
        idx++;
        for(int i=0;i<curr.length;i++){
            preArr[idx] = curr[i];
            int currLen = curr.length;
                char[] newCurr = new char[currLen-1];
            System.arraycopy(curr, 0, newCurr, 0, i );
            System.arraycopy(curr,i+1, newCurr, i, currLen-i-1);
            createAnagrams(idx, preArr, newCurr);
        }
    }
}
