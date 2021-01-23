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

    public class ListNode {
        int val;
        int key;
        ListNode pre;
        ListNode next;

        ListNode(){}

        ListNode(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public void addToHead(ListNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;

//        head.next = node;
//        node.next = head.next;
//        node.pre = head;
//        head.next.pre = node;
    }

    public void removeNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    public void moveToHead(ListNode node){
        removeNode(node);
        addToHead(node);
    }

    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {

        if(map.containsKey(key)) {
            moveToHead(map.get(key));
            return map.get(key).val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {

        ListNode node = map.get(key);

        if(node!=null){
            node.val = value;
            moveToHead(node);
        }else {
            ListNode newNode = new ListNode(key, value);
            addToHead(newNode);
            map.put(key,newNode);
            size++;

            if(size>capacity) {
            //超出容量时，先移除节点
            ListNode deleNode = tail.pre;
            removeNode(deleNode);
            map.remove(deleNode.key);
            size--;
            }

        }

    }


    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

}
