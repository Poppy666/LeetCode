package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * Author: jingren
 * Date: 2020/9/2
 * Time: 下午7:31
 */
public class Solution143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode midNode = findMidNode(head);
        ListNode lastHalf = reverse(midNode);
        ListNode pre = new ListNode(-1);
        ListNode p = head;
        ListNode q = lastHalf;
        pre.next = head;
        ListNode curr = pre;
        int i = 0;
        while (p != null && q != null) {
            if (i == 0) {
                curr.next = p;
                p = p.next;
                i = 1;
            } else {
                curr.next = q;
                q = q.next;
                i = 0;
            }
            curr = curr.next;
        }
        return;
    }

    private ListNode findMidNode(ListNode head){

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next!= null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode node = reverse(head.next);




    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
