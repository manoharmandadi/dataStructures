package com.manosoft.datastructures.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileOutput {

    public static final Logger logger = LogManager.getLogger(BufferedFileOutput.class);

    private String fileName;
    private BufferedWriter bw ;

    public BufferedFileOutput(String fileName){
        this.fileName = fileName;
    }

    public void createFile(){
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException ex){
            logger.info("Unable to create file");
            throw new RuntimeException(ex);
        }
    }

    public void writeOutput(String output){
        try {
            bw.write(output);
            bw.newLine();
        } catch (IOException e) {
            logger.info("Unable to write to file");
            throw new RuntimeException(e);
        }
    }

    public void close(){
        try {
            bw.flush();
            bw.close();
        } catch (IOException e) {
            logger.info("Unable to close file");
            throw new RuntimeException(e);
        } finally {
            bw = null;
        }
    }
}
