package com.leetcode.List;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 剑指 Offer 06. 从尾到头打印链表
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：0 <= 链表长度 <= 10000
 * 思路：采用栈，借助栈先进后出的特点
 * Author: jingren
 * Date: 2020/8/8
 * Time: 5:25 PM
 */
public class Solution_Offer_06 {

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int len = stack.size();
        int[] result = new int[len];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop().val;
        }
        return result;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
