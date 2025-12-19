package com.manosoft.datastructures.tree;

public class Node<T> {
    public Node<T> left;
    public Node<T> right;
    public int nodeVal;
    public T t;

    @Override
    public String toString() {
        return nodeVal + " L" + (left != null ? left.nodeVal : "null") + " R" + (right != null ? right.nodeVal : "null");
    }
}
