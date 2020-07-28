package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * Author: jingren
 * Date: 2020/7/24
 * Time: 上午9:56
 */
public class Solution23 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                //为什么不是curr = curr.next.next; 这种方式只是遍历的时候跳过了一个节点而非删除了一个节点
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;

    }

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

}
