package com.leetcode.List;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * Author: jingren
 * Date: 2021/3/8
 */
public class Solution445 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (!s1.isEmpty() && !s2.isEmpty()){
            temp.next = new ListNode(s1.pop()+s2.pop());
            temp = temp.next;
        }

        while (!s1.isEmpty()){
            temp.next = new ListNode(s1.pop());
            temp = temp.next;
        }
        while (!s2.isEmpty()){
            temp.next = new ListNode(s2.pop());
            temp = temp.next;
        }
        return dummy.next;
    }

}
