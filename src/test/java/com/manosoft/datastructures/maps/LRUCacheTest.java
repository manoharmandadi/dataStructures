package com.manosoft.datastructures.maps;

import com.manosoft.datastructures.cache.Cacheable;
import com.manosoft.datastructures.cache.LRUCache;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    @Test
    public void test(){
            LRUCache<String, Cacheable<Integer>> cache = new LRUCache<>(3,15000);
            cache.put("One", new Cacheable<>(1));
            cache.put("Two", new Cacheable<>(2));
            cache.put("Three", new Cacheable<>(3));

            assert cache.size() == 3;
            assert cache.get("One").get() == 1;
            assert cache.get("Two").get() == 2;
            assert cache.get("Three").get() == 3;

            // Adding a fourth entry should evict the least recently used entry ("One")
//        assertThrows(RuntimeException.class, () -> {cache.put("Four", 4);});
            cache.put("Four", new Cacheable<>(4));
            assert cache.size() == 3;
            assert cache.get("One") == null; // "One" should be evicted
            assert cache.get("Two").get() == 2;
            assert cache.get("Three").get() == 3;
            assert cache.get("Four").get() == 4;

            // Access "Two" to make it recently used
            cache.get("Two");

            // Adding another entry should evict "Three" now
            cache.put("Five", new Cacheable<>(5));
            assert cache.size() == 3;
            assert cache.get("Three") == null; // "Three" should be evicted
            assert cache.get("Two").get() == 2; // "Two" should still be present
            assert cache.get("Four").get() == 4; // "Four" should still be present
            assert cache.get("Five").get() == 5; // "Five" should be present
    }
}
