package com.manosoft.datastructures.cache;


import lombok.Getter;
import lombok.Setter;

public class Cacheable<V> {

    private V value;
    @Getter
    @Setter
    private long lastAccessedTime;

    public Cacheable(V value) {
        this.value = value;
        this.lastAccessedTime = System.currentTimeMillis();
    }

    public V get() {
        return value;
    }
}
