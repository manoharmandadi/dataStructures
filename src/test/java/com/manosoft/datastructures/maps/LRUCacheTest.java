package com.manosoft.datastructures.maps;

import com.manosoft.datastructures.cache.LRUCache;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    @Test
    public void test(){
        {
            LRUCache<String, Integer> map = new LRUCache<>(3);
            map.put("One", 1);
            map.put("Two", 2);
            map.put("Three", 3);

            assert map.size() == 3;
            assert map.get("One") == 1;
            assert map.get("Two") == 2;
            assert map.get("Three") == 3;

            // Adding a fourth entry should evict the least recently used entry ("One")
//        assertThrows(RuntimeException.class, () -> {map.put("Four", 4);});
            map.put("Four", 4);
            assert map.size() == 3;
            assert map.get("One") == null; // "One" should be evicted
            assert map.get("Two") == 2;
            assert map.get("Three") == 3;
            assert map.get("Four") == 4;

            // Access "Two" to make it recently used
            map.get("Two");

            // Adding another entry should evict "Three" now
            map.put("Five", 5);
            assert map.size() == 3;
            assert map.get("Three") == null; // "Three" should be evicted
            assert map.get("Two") == 2; // "Two" should still be present
            assert map.get("Four") == 4; // "Four" should still be present
            assert map.get("Five") == 5; // "Five" should be present
        }
    }
}
