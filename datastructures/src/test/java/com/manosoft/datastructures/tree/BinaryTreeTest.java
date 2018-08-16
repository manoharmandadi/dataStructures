package com.manosoft.datastructures.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
	
	private BinaryTree<String> binaryTree;
	
	@Before
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
	
	@After
	public void tearDown(){
		binaryTree = null;
	}
}
