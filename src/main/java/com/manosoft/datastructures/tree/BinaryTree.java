package com.manosoft.datastructures.tree;

public class BinaryTree <T extends Comparable<T>> {


	Node<T> root = null;
	
	
	public T find(T t){
		if(root==null){
			return null;
		}
		Node<T> node =  find(root, t);
		return node.t;
	}

	private Node<T> find(Node<T> currRoot, T t){
		int compareVal = currRoot.t.compareTo(t);
		if( compareVal == 0){
			return currRoot;
		} else if(compareVal > 0){
			if(hasLeftChild(currRoot)){
				return find(currRoot.left, t);
			}
			
		} else if(compareVal < 0){
			if(hasRightChild(currRoot)){
				return find(currRoot.right, t);
			}
		}
		return null;
	}
	
	public void insert(T t){
		Node<T> node = new Node<T>();
		node.t = t;
		if(root==null){
			root = node;
		} else {
			insert(root, t);
		}
		
	}
	
	private void insert(Node<T> currNode, T t){
		Node<T> node = new Node<T>();
		node.t = t;
		int comareVal = currNode.t.compareTo(t);
		if( comareVal == 0){
			System.out.println("Already Exists. Replacing with new Value");
			currNode.t = t;
		} else if(comareVal > 0){
			if(hasLeftChild(currNode)){
				insert(currNode.left, t);
			} else {
				currNode.left = node;
			}
		} else if (comareVal < 0){
			if(hasRightChild(currNode)){
				insert(currNode.right, t);
			} else {
				currNode.right = node;
			}
		}
	}
	
	private boolean hasChild(Node<T> node){
		return !(node.left==null && node.right==null);
	}
	
	private boolean hasLeftChild(Node<T> node){
		return (node.left != null);
	}
	private boolean hasRightChild(Node<T> node){
		return (node.right != null);
	}

	public T delete(T t){
		if(root == null){
			System.out.println("No Elements in Tree");
		}
		Node<T> currNode = root;
		Node<T> parentNode = root;
		boolean isLeftChild = false;
		while(currNode.t.compareTo(t) != 0){
			parentNode = currNode;
			if(currNode.t.compareTo(t) < 0 ){
				currNode = currNode.right;
				isLeftChild = false;
			} else {
				isLeftChild = true;
				currNode = currNode.left;
			}
			if(currNode == null){
				System.out.println("Didnt find the element to Delete");
				return null;
			}
		}
		//currNode is the one to be deleted
		if(!hasChild(currNode)){
			System.out.println("Has no Child"+currNode);
			updateChild(parentNode, null, isLeftChild);
		} else {
			if(hasLeftChild(currNode) && hasRightChild(currNode)){
				System.out.println("Has both child. Find Successor");
				Node<T> successor = findSuccessor(currNode);
				System.out.println("Successor"+successor);
				successor.left = currNode.left;
				successor.right = currNode.right;
				
				if(isLeftChild){
					parentNode.left = successor;
				} else {
					parentNode.right = successor;
				}
				
			} else {
				if(hasLeftChild(currNode)){
					updateChild(parentNode, currNode.left, isLeftChild);
				} else {
					updateChild(parentNode, currNode.right, isLeftChild);
				}
			}
		}
		return currNode.t;
	}

	private Node<T> findSuccessor(Node<T> currNode){
		currNode = currNode.right;
		Node<T> parentNode = currNode.right;
		while(currNode.left!=null){
			parentNode = currNode;
			currNode = currNode.left;
		}
		// currNode is successor(No Left Child).
		if(hasRightChild(currNode)){
			parentNode.left = currNode.right;
		} else {
			parentNode.left = null;
		}
		
		return currNode;
	}
	
	private void updateChild(Node<T> parent, Node<T> child, boolean isLeftChild){
		if(isLeftChild){
			parent.left = child;
		} else {
			parent.right = child;
		}
	}
	
	public void display(){
		display(root);
	}
	private void display(Node<T> currNode){
		if(hasLeftChild(currNode)){
//			System.out.print("L");
			display(currNode.left);
		}
		System.out.println(currNode.t);
		if(hasRightChild(currNode)){
//			System.out.print("R");
			display(currNode.right);
		}
	}
	

	public void inOrderTraverse(){
		inOrderTraverse(root);
	}
	
	private void inOrderTraverse(Node<T> node){
		if(hasLeftChild(node)){
			inOrderTraverse(node.left);
		}
		System.out.println(node);
		if(hasRightChild(node)){
			inOrderTraverse(node.right);
		}
	}
}
