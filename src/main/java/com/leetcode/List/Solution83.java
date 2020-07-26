package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * Author: jingren
 * Date: 2020/7/20
 * Time: 9:24 AM
 */
public class Solution83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; //不是curr = curr.next.next; 这样并没有修改链接，只是遍历的时候跳过了重复节点
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
