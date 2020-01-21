package com.manosoft.datastructures.linear;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stack {
    
    private static final Logger logger = LoggerFactory.getLogger(Stack.class);
    
    private Object[] arr ;

    private int currIdx = -1;
    private static int DEFAULT_SIZE = 10;
    
    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size) {
        arr = new Object[size];
    }
    
    public void push(Object obj) {
        arr[++currIdx] = obj;
    }
    
    public Object pop() {
        if(currIdx < 0) {
            logger.error("Stack is Empty.");
            return null;
        } else {
            return arr[currIdx--];
        }
    }

    public Object peep() {
        if(currIdx < 0) {
            logger.error("Stack is Empty.");
            return null;
        } else {
            return arr[currIdx];
        }
        
    }
}
