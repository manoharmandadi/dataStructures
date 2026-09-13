package com.manosoft.datastructures.web.service;

import com.manosoft.datastructures.cache.Cacheable;
import com.manosoft.datastructures.cache.LRUCache;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService<K,V> {

    private Map<String, LRUCache> cacheMap;

    public CacheService() {
        this.cacheMap = new HashMap<>();
        cacheMap.put("employeeCache", new LRUCache<K, Cacheable<V>>(100, 60000));
    }


    public void put(String cacheName, K key, V value) {
        LRUCache<K, Cacheable<V>> cache = cacheMap.get(cacheName);
        if (cache != null) {
            cache.put(key, new Cacheable<>(value));
        }
    }

    public V get(String cacheName, K key) {
        LRUCache<K, Cacheable<V>> cache = cacheMap.get(cacheName);
        if (cache != null) {
            Cacheable<V> cacheable = cache.get(key);
            if (cacheable != null) {
                return cacheable.get();
            }
        }
        return null;
    }

}
