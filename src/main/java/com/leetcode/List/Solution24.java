package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例: 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * Author: jingren
 * Date: 2020/8/20
 * Time: 上午9:29
 */
public class Solution24 {

    //递归
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    //遍历
    public ListNode swapPairs_method2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        dummy.next = head;
        ListNode pre = dummy;
        while (firstNode != null && secondNode!=null) {

            pre.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            pre = firstNode;
            firstNode = firstNode.next;
            if (firstNode != null) {  //没有这个判断会报空指针异常
                secondNode = firstNode.next;
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
