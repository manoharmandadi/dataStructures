package com.manosoft.datastructures.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
	
	private BinaryTree<String> binaryTree;
	
	@BeforeEach
	public void setUp(){
		binaryTree = new BinaryTree<String>();
		binaryTree.insert(7, "Seven");
		binaryTree.insert(6, "Six");
		binaryTree.insert(5, "Five");
		binaryTree.insert(4, "Four");
		binaryTree.insert(3, "Three");
	}

	@Test
	public void testGet(){
		assertEquals("Six", binaryTree.find(6));
		assertEquals("Three", binaryTree.find(3));
		assertEquals("Seven", binaryTree.find(7));
		assertEquals("Four", binaryTree.find(4));
		assertEquals("Five", binaryTree.find(5));
	}

	@Test
	public void testInsert(){
		binaryTree.insert(9, "Nine");
		assertEquals("Nine", binaryTree.find(9));
	}
	
	@Test
	public void testDelete(){
		assertEquals("Five", binaryTree.delete(5));
		assertNull(binaryTree.delete(5));
	}
	
	@Test
	public void testTraversal(){
		binaryTree.inOrderTraverse();
	}
	
	@AfterEach
	public void tearDown(){
		binaryTree = null;
	}
}
