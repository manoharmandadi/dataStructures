package com.manosoft.datastructures.tree;

public class Node<T extends Comparable<T>> {
    public Node<T> left;
    public Node<T> right;
    public T t;

    @Override
    public String toString() {
        return t+ " L" + (left != null ? left.t : "null") + " R" + (right != null ? right.t : "null");
    }
}
