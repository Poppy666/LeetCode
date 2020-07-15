package com.leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 剑指 Offer 22. 链表中倒数第k个节点
 * 对比 Solution_02_02
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * Author: jingren
 * Date: 2020/7/15
 * Time: 上午9:41
 */
public class Solution_Offer_22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        return list.get(list.size() - k);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
