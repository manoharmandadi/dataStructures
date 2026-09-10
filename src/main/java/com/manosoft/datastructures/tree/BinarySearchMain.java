package com.manosoft.datastructures.tree;

import com.manosoft.datastructures.linear.NumberNames;
import com.manosoft.datastructures.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinarySearchMain {

    public static final Logger logger = LogManager.getLogger(BinarySearchMain.class);
//    getLogger(BinarySearchMain.class);

    public static void main(String[] args) {
        BinaryTree<Person> btree = new BinaryTree<>();
        Random random = new Random();
        int toFind = 0;
        for(int i=0; i<30; i++){
            int num = random.nextInt( );
            Person p = new Person(num, NumberNames.numberToName(num), "LastName"+num);
            btree.insert(p);
            if(i==15) toFind = p.getID();
        }
        btree.display();

        Person personToFind = new Person(toFind, null, null);
         logger.info("Depth First Search for Person : {} , Found :{}",personToFind, btree.find(personToFind));

//        logger.info("Max Depth of this Tree is : {} ", btree.maxDepth());


//        List<Node<Person>> nodeList = new ArrayList<>();
//        nodeList.add(btree.root);
//        Person result = search(nodeList, personToFind);
//        logger.info("Result of Breadth First search for " + personToFind + " is: " + result);

    }


    //Breadth First Search
    public static Person search(List<Node<Person>> nodeList, Person value) {
        if(nodeList.isEmpty()){
            return null;
        }
        List<Node<Person>> nextNodelist = new ArrayList<>();
        for(Node<Person> n : nodeList){
            if(n.t.getID()==value.getID()){
                return n.t;
            } else {
                if(n.left!=null){
                    nextNodelist.add(n.left);
                }
                if(n.right!=null){
                    nextNodelist.add(n.right);
                }
            }
        }
        logger.info("Searching for " + value + " in next level nodes: " + nextNodelist);
        return search(nextNodelist, value);
    }

}
