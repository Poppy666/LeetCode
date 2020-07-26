package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 思路：用快慢指针，快指针走两步，慢指针走一步，最终快追上慢的，说明有环
 * Author: jingren
 * Date: 2020/7/25
 * Time: 10:57 AM
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {  //注意这里需要考虑一个节点的情况
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;

    }

    /**
     * 官方解答写法
     * @param head
     * @return
     */
    public boolean hasCycle_Two(ListNode head){
        if (head == null || head.next == null) {  //注意这里需要考虑一个节点的情况
            return false;
        }
        ListNode fast = head.next;  //注意这里，如果快指针和慢指针相同的话，则进入循环第一次就结束了
        ListNode slow = head;

        while (fast != null && fast.next != null && slow != null) {

            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
