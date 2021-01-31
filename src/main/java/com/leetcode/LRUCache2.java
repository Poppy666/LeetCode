package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2021/1/23
 * Time: 12:34 PM
 */
public class LRUCache2 extends LinkedHashMap<Integer, Integer>{

    int capacity;
    public LRUCache2(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;

    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }


    public void put(int key, int value){
        super.put(key,value);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>capacity;
    }

}


