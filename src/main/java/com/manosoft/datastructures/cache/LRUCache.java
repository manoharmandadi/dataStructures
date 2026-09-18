package com.manosoft.datastructures.cache;

import com.manosoft.datastructures.maps.Entry;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K,V> {
    public static final Logger logger = LogManager.getLogger(LRUCache.class);

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    @Getter
    private int capcity;

    private int size =0;
    @Getter
    private int ttl;
    private Node<K,Cacheable<V>> head ;
    private Node<K,Cacheable<V>> tail ;
    private Node<K,Cacheable<V>>[] entries ;

    public LRUCache(int capacity, int ttl){
        this.capcity = capacity;
        this.ttl = ttl;
        this.entries  = new Node[capcity];
    }

    public void printCache(){
        readLock.lock();
        try {
            Node<K, Cacheable<V>> current = head;
            while(current != null){
                logger.info( "{}  -> {}",current.getKey() , current.getValue().get());
                current = current.after;
            }
        } finally {
            readLock.unlock();
        }
    }

    public boolean containsKey(K k){
        readLock.lock();
        try {
            return getNode(k) != null;
        } finally {
            readLock.unlock();
        }
    }

    private Node<K,Cacheable<V>> getNode(K k){
        int index = getHashIndex(k);
        if(entries[index] == null){
            return null;
        } else {
            Node<K,Cacheable<V>> current = entries[index];
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
        // Write lock: get reorders the LRU list and may evict expired entries
        writeLock.lock();
        try {
            Node<K,Cacheable<V>> node = getNode(key);
            if(node != null){
                if(ttl > 0 && (System.currentTimeMillis() - node.getValue().getCreationTime()) > ttl){
                    evict(node);
                    return null;
                }
                updateOrder(node);
                appendToTail(node);
                return node.getValue().get();
            } else {
                return null;
            }
        } finally {
            writeLock.unlock();
        }
    }

    private void appendToTail(Node<K,Cacheable<V>> node){
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
    private void updateOrder(Node<K,Cacheable<V>> node){
        Node<K,Cacheable<V>> before = node.before;
        Node<K,Cacheable<V>> after = node.after;
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

    private Node<K,Cacheable<V>> evict(Node<K,Cacheable<V>> node ){
        updateOrder(node);
        // Update next references in the bucket
        int bucketIdx = getHashIndex(node.getKey());
        Node<K,Cacheable<V>> bucketHead = entries[bucketIdx];
        if(bucketHead == node){
            entries[bucketIdx] = node.next;
        } else {
            Node<K,Cacheable<V>> current = bucketHead;
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
        writeLock.lock();
        try {
            Node<K,Cacheable<V>> existingNode = getNode(k);
            if(existingNode != null){
                Cacheable<V> prevVal = existingNode.getValue();
                existingNode.setValue(new Cacheable<>(v));
                return prevVal.get();
            }
            if(size == capcity){
                evict(head);
            }

            Node<K,Cacheable<V>> newNode = new Node<>(k,new Cacheable<>(v));
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
                Node<K,Cacheable<V>> current = entries[index];
                while(current.next != null){
                    current = current.next;
                }
                //Now current is the last node in the linked list for this bucket, so we can add the new node to the end
                current.next = newNode;
            }
            return newNode.value.get();
        } finally {
            writeLock.unlock();
        }
    }


    private int getHashIndex(K k){
        return (k.hashCode() & 0x7FFFFFFF) % capcity;
    }

    public int size(){
        readLock.lock();
        try {
            return size;
        } finally {
            readLock.unlock();
        }
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
