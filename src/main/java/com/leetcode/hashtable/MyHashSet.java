package com.leetcode.hashtable;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Project: 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * <p>
 * Author: jingren
 * Date: 2020/11/5
 */
public class MyHashSet {

    //    LinkedList<Object> list;
    LinkedList[] buckets;
    private final int length = 769;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        buckets = new LinkedList[length];
//        for(int i=0;i<length;i++){
//            buckets[i] = new LinkedList<>();
//        }
//        list = new LinkedList<>();
    }

    public void add(int key) {

        int hash = key % length;
        if (buckets[hash] == null) {
            LinkedList<Object> list = new LinkedList<>();
            list.add(key);
            buckets[hash] = list;
        }
//        if(!contains(key)){
//            list.add(key);
//        }
    }

    public void remove(int key) {
        int hash = key % length;
        LinkedList list = buckets[hash];
        if (list != null) {
            list.remove((Object) key);
        }

//        list.remove((Object) key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = key % length;
        LinkedList list = buckets[hash];
        if (list != null) {
            return list.contains(key);
        }
        return false;
    }

    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
}
