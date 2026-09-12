package com.manosoft.datastructures.maps;

import lombok.Getter;
import lombok.Setter;

/*** HashMap with fixed size.
 * Wont grow after the initial capacity is reached. It will evict the least recently used entry when a new entry is added after reaching the capacity.
**/
public class FixedSizeLinkedHashMap<K,V> {
    @Getter
    private int capcity;
    @Getter
    private int size =0;
    private Node<K,V> head = null;
    private Node<K,V> tail = null;
    private Entry<K,V>[] entries = null;

    public FixedSizeLinkedHashMap(int capacity){
        this.capcity = capacity;
        this.entries  = new Entry[capcity];
    }

    public boolean containsKey(K k){
        return getNode(k) != null;
    }

    private Node<K,V> getNode(K k){
        int index = getHashIndex(k);
        if(entries[index] == null){
            return null;
        } else {
            Node<K,V> current = (Node<K,V>) entries[index];
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
            return node.getValue();
        } else {
            return null;
        }
    }

    public V put(K k, V v){
        // If Key Exists, update the value and return the previous value
        Node<K,V> existingNode = getNode(k);
        if(existingNode != null){
            V prevVal = existingNode.getValue();
            existingNode.setValue(v);
            return prevVal;
        }
        // TODO: Evict if size is at capacity


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
            Node<K,V> current = (Node<K,V>) entries[index];
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
