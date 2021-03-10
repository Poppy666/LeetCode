package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 反转链表
 * Author: jingren
 * Date: 2021/3/7
 * Time: 3:35 PM
 */
public class Solution_Offer_24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;   //这里不能用 ListNode dummy = new ListNode(0);这样的dummy节点，因为反转后的链表的尾节点指向的是null，如果用dummy的话，那么指向的是dummy，从而形成环形链表
        while (curr != null) {

            ListNode temp = curr.next;
            curr.next = pre;

            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
