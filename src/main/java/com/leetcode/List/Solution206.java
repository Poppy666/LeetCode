package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 206. 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * Author: jingren
 * Date: 2020/7/4
 * Time: 上午11:51
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next; //保存当前链表的下一个节点
            curr.next = pre; //修改链表，当前链表的下一个节点指向原来的上一个节点
            pre = curr; //修改链表，当前节点变成上一个节点
            curr = temp; //原链表的中当前节点的下一个节点变成当前节点
        }
        return pre;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
