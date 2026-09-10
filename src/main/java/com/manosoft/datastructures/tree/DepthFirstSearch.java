package com.manosoft.datastructures.tree;

import com.manosoft.datastructures.linear.NumberNames;

import java.util.Random;

public class DepthFirstSearch<T extends Comparable<T>> {


    public static void main(String[] args) {
        BinaryTree<Integer> btree = new BinaryTree<>();
        Random random = new Random();
        int val =0;

        for(int i=0; i<30; i++){
            int num = random.nextInt( );
            btree.insert(num);
            if(i==15) val = num;
//            System.out.print(num+" ");
        }
//        btree.insert(5);
//        btree.insert(9);
//        btree.insert( 2);
//        btree.insert(6);
//        btree.insert(4);
//        btree.insert(1);
//        btree.insert(10);
//        btree.display();
        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
        dfs.search(btree.root, val);
    }
    public Integer search(Node<Integer> node, int value){
        System.out.println("Searching for " + value + " in node " + node.t);
        if(node == null)    {
            return null;
        }
        if(node.t.equals(value)) {
            return node.t;
        } else if (node.t > value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }
}
