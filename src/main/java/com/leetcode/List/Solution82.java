package com.leetcode.List;

import com.google.common.collect.Maps;

import java.util.LinkedHashMap;

/**
 * Created with IntelliJ IDEA
 * Project: 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 思路一：常规做法，用map遍历链表，同时把节点值出现的次数存起来，然后把出现一次的节点拼成一个新链表，需要注意的是链表是有序的，因此可以用LinkedHashMap
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
            ListNode nextNode = curr.next.next;
            boolean flag = false;
            while (nextNode != null && nextNode.val == temp.val) {
                nextNode = nextNode.next;
                flag = true;
            }
            if (flag) {
                curr.next = nextNode;
            } else {
                curr = curr.next;
            }
        }
        return pre.next;

    }

    //与上一个方法是同一种思路，写法更优雅
    public ListNode deleteDuplicates_two(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                ListNode temp = curr.next;
                while (temp != null && temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                curr.next = temp.next;

            } else {
                curr = curr.next;
            }
        }
        return pre.next;
    }

    public ListNode deleteDuplicates_methodOne(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        LinkedHashMap<Integer, Integer> map = Maps.newLinkedHashMap();
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        ListNode curr = pre;
//        while (curr.next != null && curr.next.next != null) {
//            if (curr.next.val == curr.next.next.val) {
//                ListNode temp = curr.next;
//                while (temp != null && temp.next != null && temp.next.val == temp.val) {
//                    temp = temp.next;
//                }
//                curr.next = temp.next;
//
//            } else {
//                curr = curr.next;
//            }
//        }
//        return pre.next;
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
