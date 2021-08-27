/******************************************************************************
 *             COPYRIGHT 2020 BY Dell EMC.
 *                 ALL RIGHTS RESERVED
 *
 *   THIS DOCUMENT OR ANY PART OF THIS DOCUMENT MAY NOT BE
 *   REPRODUCED WITHOUT WRITTEN PERMISSION FROM Dell EMC.
 *
 ******************************************************************************/
package com.manosoft.datastructures.model;

/**
 * TODO
 *
 * @author Manohar_Mandadi
 *
 **/

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
