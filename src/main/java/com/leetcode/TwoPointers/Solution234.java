package com.leetcode.TwoPointers;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * Project: 回文链表
 * 请判断一个链表是否为回文链表。
 * 输入: 1->2->2->1
 * 输出: true
 * 思路：首先遍历链表将位置和值存起来，然后再判断对应位置上的值，时间负责度O(n)，空间复杂度O(n)
 * Author: jingren
 * Date: 2020/6/29
 * Time: 上午9:49
 */
public class Solution234 {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        int len = 0;
        ListNode tmp = head;
        map.put(len, tmp);  
        while (tmp.next != null) {  
            len++;         
            map.put(len, tmp.next);  
            tmp = tmp.next; 
        }
        int i = 0;
        while (i < len / 2.0) {  //注意这里用2.0,就不用区分奇数个节点和偶数个节点
            if (map.get(i).val != map.get(len - i).val) {
                return false;
            }
            i++;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    
}
