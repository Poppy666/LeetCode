package com.leetcode.TwoPointers;

/**
 * Created with IntelliJ IDEA
 * Project: 环形链表 II，给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * 思路：在141的基础上，根基2(F + a) = F + N(a + b) + a，N为快指针跑第几圈会与慢指针相遇，可推出，N=1时，F=b
 * F:环外部分的长度，a:入环后到相遇点距离，b：相遇点到入环口距离
 * Author: jingren
 * Date: 2020/6/28
 * Time: 下午3:38
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {

        ListNode meetNode = hasCycle(head);
        if(meetNode==null){
            return null;
        }
        ListNode n1 = head;
        ListNode n2 = meetNode;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public ListNode hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null && slow.next != null) {
            if (fast.next.next == slow.next) {
                return slow.next;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;

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
