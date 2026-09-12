package com.manosoft.datastructures.maps;

public interface Entry<K, V> {
    K getKey();
    V getValue();
    void setValue(V value);
}