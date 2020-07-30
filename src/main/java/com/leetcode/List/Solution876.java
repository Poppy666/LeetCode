package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 876. 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。 [1,2,3,4,5]，返回3
 * 如果有两个中间结点，则返回第二个中间结点。[1,2,3,4,5,6]，返回4
 * 思路一：遍历一遍链表，得到链表的长度，然后第二个遍历得到中间节点。也可以在第一遍遍历的同时把节点存起来。
 * 思路二：用两个快慢指针，快指针走两步，慢指针走一步，当快指针到达链表末尾时，慢指针刚好走到中间
 * Author: jingren
 * Date: 2020/7/30
 * Time: 下午7:49
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
