package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 * 输入：head = [1,0,1]
 * 输出：5
 * 思路:
 * Author: jingren
 * Date: 2020/7/31
 * Time: 下午6:15
 */
public class Solution1290 {

    public int getDecimalValue(ListNode head) {
//        if (head == null) {
//            return 0;
//        }
//        ListNode curr = head;
//        int result = 0;
//        int i = 0;
//        while (curr != null) {
//            result += (curr.val ^ 1) * Math.pow(2, i++);
//            curr = curr.next;
//        }
//        return result;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
