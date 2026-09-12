package com.manosoft.datastructures.web.dto;

public class SortResponse<E extends Comparable<E>> {

    private E[] arr;
    private int comparisions;
    private int swappings;

    public SortResponse(E[] arr, int comparisions, int swappings) {
        this.arr = arr;
        this.comparisions = comparisions;
        this.swappings = swappings;
    }

    public E[] getArr()
    {
        return arr;
    }

    public void setArr(E[] arr)
    {
        this.arr = arr;
    }

    public int getComparisions()
    {
        return comparisions;
    }

    public void setComparisions(int comparisions)
    {
        this.comparisions = comparisions;
    }

    public int getSwappings()
    {
        return swappings;
    }

    public void setSwappings(int swappings)
    {
        this.swappings = swappings;
    }
}
