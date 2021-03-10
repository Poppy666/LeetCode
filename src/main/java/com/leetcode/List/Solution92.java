package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

 说明:
 1 ≤ m ≤ n ≤ 链表长度。

 * Author: jingren
 * Date: 2021/3/7
 * Time: 2:59 PM
 */
public class Solution92 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        int x = 0;
        int y = 0;
        ListNode subList = null; //翻转子链表头节点，用来保存子链表
        ListNode pre = null; //记录翻转头节点的前一个节点
        ListNode next = null; //记录翻转尾节点的下一个节点
        //找到pre
        for(int i=0;i<m-1;i++){
            temp = temp.next;
        }
        pre = temp;
        subList = temp.next;

        //找到子链表的尾节点
        for(int i=0;i<=n-m;i++){
            temp = temp.next;
        }
        next = temp.next;
        temp.next = null; //切断子链表

        ListNode newHead = reverseList(subList);
        pre.next = newHead;
        subList.next = next;
        return dummy.next;    //这里不能返回head。如果返回head，那么如果本身head做了翻转的话，就错了
    }

    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {

            ListNode temp = curr.next;
            curr.next = pre;

            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
