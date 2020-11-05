package com.leetcode.hashtable;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Project: 706. 设计哈希映射
 *
 * 不使用任何内建的哈希表库设计一个哈希映射

 具体地说，你的设计应该包含以下的功能

 put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 remove(key)：如果映射中存在这个键，删除这个数值对。

 * Author: jingren
 * Date: 2020/11/5
 */
public class MyHashMap {

    LinkedList[] buckets;
    private final int length = 769;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new LinkedList[length];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
//        int hash = key % length;
//        LinkedList list = buckets[hash];
//        if (list == null) {
//            LinkedList<Object> ll = new LinkedList<>();
//            ll.add(value);
//            buckets[hash] = ll;
//        }else {
//            list.get()
//
//        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % length;
        LinkedList list = buckets[hash];
        if (list != null) {
//            for(Object item :list){
//                if(item.equals(key))
//            }

        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % length;
        LinkedList list = buckets[hash];
        if (list != null) {
            list.remove((Object) key);
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */

}
