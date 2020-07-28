package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 思路：首先判断链表是不是有环，如果有环，找到相遇的节点。然后重新用两个指针，分别从链表入口和相遇点开始走，再次相遇位置则为环的第一个节点。
 * 结论：相遇点距离入环第一个节点的距离与链表头距离入环第一个节点的距离相等。
 * 这个题适合图解法，把图一画，距离设置好。2(L+S) = L+S+D+S => L=D
 * Author: jingren
 * Date: 2020/7/28
 * Time: 下午4:55
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        ListNode crossNode = hasCycle(head);
        if (crossNode == null) {
            return null;
        }
        ListNode p = crossNode;
        ListNode q = head;
        while (p!=q){
            p = p.next;
            q = q.next;
        }
        return p;

    }

    public ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
