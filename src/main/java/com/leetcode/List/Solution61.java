package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 思路：第一遍将链表首尾相连顺便记录链表的长度，第二遍遍历记录链表断开的位置(链表长度的按%n处理)
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * Author: jingren
 * Date: 2020/8/20
 * Time: 上午9:30
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }

        int len = 1;
        ListNode curr = head;
        while(curr.next!=null){
            curr=curr.next;
            len++;
        }
        curr.next = head;

        ListNode temp = head;
        ListNode newHead = null;

        int move = k<len?k:k%len;
        for(int i=0;i<len-move-1;i++){   //注意，这里是len-move-1？而不是move
            temp = temp.next;
        }
        newHead = temp.next;
        temp.next = null;
        return newHead;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
