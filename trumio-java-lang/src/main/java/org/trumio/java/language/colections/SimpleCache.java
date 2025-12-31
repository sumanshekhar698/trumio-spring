package org.trumio.java.language.colections;

import java.util.HashMap;

public class SimpleCache {

	// HashMap to act as our cache
	private HashMap<String, String> cacheMap;

	public SimpleCache() {
		cacheMap = new HashMap<>();
	}

	// Method to add item to cache
	public void putInCache(String key, String value) {
		cacheMap.put(key, value);
		System.out.println("Added to cache: " + key + " -> " + value);
	}

	// Method to get item from cache
	public String get(String key) {
		if (cacheMap.containsKey(key)) {
			System.out.println("Cache hit for key: " + key);
			return cacheMap.get(key);
		} else {
			System.out.println("Cache miss for key: " + key);
			return null;
		}
	}

	public static void main(String[] args) {
		SimpleCache myCache = new SimpleCache();

		// Add some values to cache
		myCache.putInCache("1", "Apple");
		myCache.putInCache("2", "Banana");

		// Retrieve values
		System.out.println("Value for key 1: " + myCache.get("1")); // Cache hit
		System.out.println("Value for key 3: " + myCache.get("3")); // Cache miss || In this case there can be a DB call
	}
}
