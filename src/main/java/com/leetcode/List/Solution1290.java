package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 * 输入：head = [1,0,1]
 * 输出：5
 * 思路: 链表移动到右侧下一个节点的过程，就是二进制数左移1位的结果。
 * Author: jingren
 * Date: 2020/7/31
 * Time: 下午6:15
 */
public class Solution1290 {

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int res = 0;
        ListNode curr = head;
        while (curr != null) {
            res = (res << 1) + curr.val;  //注意要加括号，不然先计算的是1+curr.val
            curr = curr.next;
        }
        return res;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
