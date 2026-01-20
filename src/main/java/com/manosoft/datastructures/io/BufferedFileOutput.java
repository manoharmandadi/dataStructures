package com.manosoft.datastructures.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileOutput {

    private String fileName;
    private BufferedWriter bw ;

    public BufferedFileOutput(String fileName){
        this.fileName = fileName;
    }

    public void createFile(){
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException ex){
            System.out.println("Unable to create file");
            throw new RuntimeException(ex);
        }
    }

    public void writeOutput(String output){
        try {
            bw.write(output);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
            throw new RuntimeException(e);
        }
    }

    public void close(){
        try {
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Unable to close file");
            throw new RuntimeException(e);
        } finally {
            bw = null;
        }
    }
}
