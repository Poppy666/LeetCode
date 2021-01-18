package com.leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 * Project: 146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 * <p>
 * Author: jingren
 * Date: 2021/1/18
 */
public class LRUCache {

    int[] nums; //存储key，value
    HashMap<Integer, Integer> useFreMap; //存储key，更新时间
    int capacity;
    int fre = 0; //记录数据的更新时间
    int len = 0; //记录存入数据的个数

    public LRUCache(int capacity) {

        nums = new int[3001];
        this.capacity = capacity;

        useFreMap = new HashMap<>();
    }

    public int get(int key) {
        if (nums[key] != 0) {
            fre++;
            useFreMap.put(key, fre);
            return nums[key];
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if(nums[key] != 0){
            nums[key] = value;

        }else if(len < capacity){
            nums[key] = value;
            len ++;
        }else{
            //移除最少使用
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(useFreMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            Integer delKey = list.get(0).getKey();
            nums[delKey]=0;
            len --;
            useFreMap.remove(delKey);

            nums[key]=value;
            len ++;
        }
        fre++;
        useFreMap.put(key, fre);
    }


    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

}
