package com.manosoft.datastructures.tree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class DepthFirstSearch<T extends Comparable<T>> {

    private static final Logger logger = LogManager.getLogger(DepthFirstSearch.class);


    public static void main(String[] args) {
        BinaryTree<Integer> btree = new BinaryTree<>();
        Random random = new Random();
        int val =0;

        for(int i=0; i<30; i++){
            int num = random.nextInt( );
            btree.insert(num);
            if(i==15) val = num;
//            logger.info(num+" ");
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
        logger.info("Searching for " + value + " in node " + node.t);
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
