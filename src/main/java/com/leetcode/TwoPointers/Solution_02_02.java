package com.leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 思路一：倒数第k个节点，即正数n-k+1个(但是不能复杂度O(1)内得到链表的长度)
 * Author: jingren
 * Date: 2020/7/14
 * Time: 上午9:19
 */
public class Solution_02_02 {
    public int kthToLast(ListNode head, int k) {

        if (head == null) {
            return -1;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        return list.get(list.size() - k).val;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
