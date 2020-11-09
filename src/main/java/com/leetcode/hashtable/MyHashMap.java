package com.leetcode.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    private List<Bucket> buckets;
    private final int length = 769;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new ArrayList<>(length);
        for(int i=0;i<length;i++){
            buckets.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % length;
        buckets.get(hash).upsert(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % length;
        return buckets.get(hash).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % length;
        buckets.get(hash).remove(key);
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */

    class Pair<U, V> {

        public U key;
        public V value;

        public Pair(U key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    class Bucket{

        LinkedList<Pair<Integer, Integer>> buckets;


        public Bucket() {
            this.buckets = new LinkedList<Pair<Integer, Integer>>();
        }

        public void upsert(Integer key, Integer value) {
            for(Pair<Integer, Integer> pair : buckets){
                if(pair.key.equals(key)){
                    pair.value = value;
                    return;
                }
            }
            Pair<Integer, Integer> pair = new Pair<>(key,value);
            buckets.add(pair);

        }

        public Integer get(Integer key) {
            for(Pair<Integer, Integer> pair : buckets){
                if(pair.key.equals(key)){
                    return pair.value;
                }
            }
            return -1;
        }

        public void remove(Integer key) {
            for(Pair<Integer, Integer> pair : buckets){
                if(pair.key.equals(key)){
                    buckets.remove(pair);
                    break;
                }
            }
        }
    }

}
