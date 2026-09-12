package com.manosoft.datastructures.cache;

import com.manosoft.datastructures.maps.Entry;
import lombok.Getter;
import lombok.Setter;

public class LRUCache<K,V> {
    @Getter
    private int capcity;
    @Getter
    private int size =0;
    private Node<K,V> head = null;
    private Node<K,V> tail = null;
    private Node<K,V>[] entries = null;

    public LRUCache(int capacity){
        this.capcity = capacity;
        this.entries  = new Node[capcity];
    }

    public boolean containsKey(K k){
        return getNode(k) != null;
    }

    private Node<K,V> getNode(K k){
        int index = getHashIndex(k);
        if(entries[index] == null){
            return null;
        } else {
            Node<K,V> current = entries[index];
            while(current != null){
                if(current.getKey().equals(k)){
                    return current;
                }
                current = current.next;
            }
            return null;
        }
    }

    public V get(K key){
        Node<K,V> node = getNode(key);
        if(node != null){
            //Move the accessed node to tail to mark it as recently used
            updateOrder(node);
            appendToTail(node);
            return node.getValue();
        } else {
            return null;
        }
    }

    private void appendToTail(Node<K,V> node){
        if(tail == null){
            head = node;
            tail = node;
        } else {
            tail.after = node;
            node.before = tail;
            tail = node;
        }
    }

    //Removes the passed Node from the current Order..
    //Should be called when a node is evicted or accessed to update the order of the linked list
    private void updateOrder(Node<K,V> node){
        Node<K,V> before = node.before;
        Node<K,V> after = node.after;
        if(before != null){
            before.after = after;
        } else {
            head = after;
        }
        if(after != null){
            after.before = before;
        } else {
            tail = before;
        }
    }

    private Node<K,V> evict(Node<K,V> node ){
        updateOrder(node);
        //TODO: Fix next references in the bucket
        int bucketIdx = node.getKey().hashCode()%capcity;
        Node<K,V> bucketHead = entries[bucketIdx];
        if(bucketHead == node){
            entries[bucketIdx] = node.next;
        } else {
            Node<K,V> current = bucketHead;
            while(current != null && current.next != node){
                current = current.next;
            }
            if(current != null){
                current.next = node.next;
            }
        }
        node.before = null;
        node.after = null;
        size--;
        return node;
    }

    public V put(K k, V v){
        // If Key Exists, update the value and return the previous value
        Node<K,V> existingNode = getNode(k);
        if(existingNode != null){
            V prevVal = existingNode.getValue();
            existingNode.setValue(v);
            return prevVal;
        }
        //  Evict if size is at capacity
        if(size == capcity){
            //Remove last node from the linked list and also remove it from the entries array
            evict(head);
        }


        Node<K,V> newNode = new Node<>(k,v);
        size++;
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        } else {
            // Add to the end of the linked list
            tail.after = newNode;
            newNode.before=tail;
            tail = newNode;
        }

        int index = getHashIndex(k);


        if(entries[index] == null){
            entries[index] = newNode;
        } else {
            // Collision handling using linked list
            Node<K,V> current = entries[index];
            while(current.next != null){
                current = current.next;
            }
            //Now current is the last node in the linked list for this bucket, so we can add the new node to the end
            current.next = newNode;
        }
        return newNode.value;
    }


    private int getHashIndex(K k){
        return k.hashCode() % capcity;
    }

    public int size(){
        return size;
    }

    @Setter
    @Getter
    static class Node<K,V> implements Entry<K,V> {
        final K key;
        V value;
        Node<K, V> next; // For collision handling in the same bucket
        Node<K, V> before;
        Node<K, V> after;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
}
