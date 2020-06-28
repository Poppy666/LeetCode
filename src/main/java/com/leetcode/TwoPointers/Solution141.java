package com.leetcode.TwoPointers;

/**
 * Created with IntelliJ IDEA
 * Project: 给定一个链表，判断链表中是否有环。为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 思路：用快慢两个指针遍历链表，如果慢指针追赶上快指针，说明链表有环
 * Author: jingren
 * Date: 2020/6/28
 * Time: 下午2:56
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null && slow.next!=null){
            if(fast.next.next ==slow.next){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
}
