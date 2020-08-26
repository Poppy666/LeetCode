package com.leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。  5-2+1  （n-k+1）
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 思路一：遍历链表，把节点存到数组中，然后直接取指定位置上的值：时间复杂度O(N),空间复杂度O(1)；或者不用数组存储，设置一个指针走 (n-k) 步，即可找到链表倒数第 kk 个节点。
 * 思路二：维护两个指针，快指针先走k步，然后快慢指针再一起走，等快指针走到尾节点的下一个节点时，此时满指针处于倒数第K个节点
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

    public int kthToLast_method(ListNode head, int k) {

        if (head == null) {
            return -1;
        }
        return -1;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
