package com.manosoft.datastructures.cache;


import lombok.Getter;
import lombok.Setter;

public class Cacheable<V> {

    private V value;
    @Getter
    @Setter
    private long creationTime;

    public Cacheable(V value) {
        this.value = value;
        this.creationTime = System.currentTimeMillis();
    }

    public V get() {
        return value;
    }
}
