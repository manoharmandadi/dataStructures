package com.manosoft.datastructures.slidingwindow;

import com.manosoft.datastructures.io.BufferedFileOutput;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Anagrams {

    static List<String> anagrams = new ArrayList<>();
    static AtomicLong  allCombinations = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();
        char[] input = "PUTORI".toCharArray(); //15PICQ
        //AZYTHROMSDPI
        // 17 sec w/o sout
        //
        BufferedFileOutput bfo = new BufferedFileOutput("anagrams.txt");
        bfo.createFile();

        Thread[] threadArr = new Thread[15];

        //"FORTYSIXMEN"; //11
        for(int i=0;i<input.length;i++){
            char[] preArr = new char[input.length];
            char[] curr = new char[input.length-1];
            System.arraycopy(input, 0 , curr, 0, i);
            System.arraycopy(input, i+1 , curr, i, input.length-i-1);
            preArr[0] = input[i];
            Run run = new Run(0, preArr, curr, allCombinations, bfo);
            run.start();
            threadArr[i] = run;
        }

        for(Thread thread : threadArr){
            if(thread!=null){
                thread.join();

            }
        }

        bfo.close();

        Instant end = Instant.now();
        System.out.println("Total Combinations : "+allCombinations.get());
        Duration timeTaken = Duration.between(start, end);
        System.out.println("Time Taken : "+timeTaken.getSeconds());

    }
}

class Run extends Thread{
    private int idx;
    private char[] preArr;
    private char[] curr;
    private int allCombinations;
    private AtomicLong finalCombinations;
    BufferedFileOutput bfo;
    Run(int idx, char[] preArr, char[] curr, AtomicLong finalCombinations, BufferedFileOutput bfo ){
        this.curr = curr;
        this.preArr = preArr;
        this.idx = idx;
        this.finalCombinations = finalCombinations;
        this.bfo = bfo;
    }

    @Override
    public void run() {
        createAnagrams(idx, preArr, curr);
        System.out.println("All Combinations: " + allCombinations);
        finalCombinations.addAndGet(allCombinations);
    }

    private void createAnagrams(int idx, char[] preArr, char[] curr) {
        if(curr.length==1){
            preArr[preArr.length-1] = curr[0];
            String result = new String(preArr);
            synchronized (bfo){
                bfo.writeOutput(result);

            }
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
