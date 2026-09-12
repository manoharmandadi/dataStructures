package com.manosoft.datastructures.web.controller;

import com.manosoft.datastructures.cache.LRUCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datastructures/cache")
public class CacheController {

    LRUCache<String, Integer> lruCache = new LRUCache<>(3, 15000); // Example cache with capacity 3 and TTL 15 seconds

    @RequestMapping(value = "/lru", method = RequestMethod.POST)
    public String createLRUCache(String key, Integer value) {
        lruCache.put(key, value);
        lruCache.printCache();
        return "LRU Cache created";
    }

    @GetMapping("/lru")
    public Integer getLRUCache(String key) {
        // Logic to retrieve the LRU cache
        return lruCache.get(key);
    }

}
