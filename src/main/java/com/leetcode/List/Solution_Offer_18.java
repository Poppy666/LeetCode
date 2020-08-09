package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 方法：用一个哨兵节点
 * Author: jingren
 * Date: 2020/8/8
 * Time: 5:41 PM
 */
public class Solution_Offer_18 {

    public ListNode deleteNode(ListNode head, int val) {

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;
        while (curr.next!=null) {

            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }

        }
        return pre.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
