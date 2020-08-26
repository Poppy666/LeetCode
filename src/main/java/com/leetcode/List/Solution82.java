package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 思路一：
 * 思路二：
 * 思路三：逆向思维，删除重复节点，那么其实找出不重复节点，然后重新组成链表
 * Author: jingren
 * Date: 2020/8/20
 * Time: 上午9:32
 */
public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next;
            ListNode nextNode = temp.next;
            boolean flag = false;
            while (nextNode != null && nextNode.val == temp.val) {
                nextNode = nextNode.next;
                flag = true;
            }
            if (flag) {
                curr.next = nextNode;
                curr = nextNode;
            } else {
                curr.next = temp;
                curr = temp;
            }
        }
        return pre.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
