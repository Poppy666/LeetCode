package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 203. 移除链表元素 删除链表中等于给定值 val 的所有节点。
 * 思路：如果当前节点的值等于目标值，则当前节点的上一个节点的next节点应该是当前节点的下一个节点。
 * 但是对于第一个节点而言，我们无法获取它的上一个节点，这里我们可以采用哨兵节点作为头节点的前一个节点，但是把它作为当前节点，然后去考虑它的下一个节点
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * <p>
 * 类似题型：Solution237
 * Author: jingren
 * Date: 2020/7/26
 * Time: 6:12 PM
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;
        while (curr != null  && curr.next!=null) {
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
            next = null;
        }
    }
}
