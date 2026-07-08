package com.manosoft.datastructures.tree;

import com.manosoft.datastructures.linear.NumberNames;

import java.util.Random;

public class DepthFirstSearch<T extends Comparable<T>> {


    public static void main(String[] args) {
        BinaryTree<Integer> btree = new BinaryTree<>();
        Random random = new Random();
        for(int i=0; i<30; i++){
            int num = random.nextInt( );
            btree.insert(num);
//            System.out.print(num+" ");
        }
/*
        btree.insert(5,5);
        btree.insert(9,9);
        btree.insert(2, 2);
        btree.insert(6,6);
        btree.insert(4,4);
        btree.insert(1,1);
        btree.insert(10,10);
*/
        btree.display();
        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
        dfs.search(btree.root);
    }
    public void search(Node<Integer> node){
        if(node !=null){
            search(node.left);
            //System.out.println(node.nodeVal);
            System.out.println(NumberNames.numberToName(node.t));
            search(node.right);
        }
    }
}
