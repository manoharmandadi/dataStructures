package com.manosoft.datastructures.linear;

public class Stack {

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
            System.out.println("Stack is Empty.");
            return null;
        } else {
            return arr[currIdx--];
        }
    }

    public Object peep() {
        if(currIdx < 0) {
            System.out.println("Stack is Empty.");
            return null;
        } else {
            return arr[currIdx];
        }
        
    }
}
