package com.manosoft.datastructures.cache;


public class Cacheable<V> {

    private V value;
    private long lastAccessedTime;

    public Cacheable(V value) {
        this.value = value;
        this.lastAccessedTime = System.currentTimeMillis();
    }

    public V get() {
        return value;
    }
}
