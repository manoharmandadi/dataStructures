package com.manosoft.datastructures.linear;

public class Queue<T> {
    
    private Object[] arr;
    
    private int readIdx = 0;
    private int writeIdx = 0;
    private boolean full = false;
    private boolean empty = true;
    
    public Queue(int size) {
        arr = new Object[size];
    }

    public void insert(T val) {
        if(full) {
            System.out.println("Error: Queue is Full");
            return;
        }
        if(empty) {
            empty = !empty;
        }
        arr[writeIdx++] = val;
        if( writeIdx == arr.length ) {
            //wrap around
            writeIdx = 0;
        }
        if(readIdx == writeIdx) {
            full = true;
        }
    }

    public T remove() {
        if(empty) {
            throw new RuntimeException("Error: Queue is Empty");
        }
        if(full) {
            full = !full;
        }
        T val = (T) arr[readIdx++];
        if( readIdx == arr.length ) {
            //wrap around
            readIdx = 0;
        }
        //Check Empty
        if(readIdx == writeIdx) {
            empty = true;
        }
        return val;
    }

    public boolean isFull() {
        return full;
    }

    public boolean isEmpty() {
        return empty;
    }
}
