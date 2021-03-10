package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

 你应当 保留 两个分区中每个节点的初始相对位置。

 思路：直观来说我们只需维护两个链表 \textit{small}small 和 \textit{large}large 即可，\textit{small}small 链表按顺序存储所有小于 xx 的节点，\textit{large}large 链表按顺序存储所有大于等于 xx 的节点。
 遍历完原链表后，我们只要将 \textit{small}small 链表尾节点指向 \textit{large}large 链表的头节点即能完成对链表的分隔。

 * Author: jingren
 * Date: 2021/3/7
 * Time: 2:49 PM
 */
public class Solution86 {


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

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode temp = head;
        ListNode s = smallHead;
        ListNode l = largeHead;
        while (temp != null) {
            if (temp.val < x) {
                s.next = temp;
                s = s.next;
            } else {
                l.next = temp;
                l = l.next;
            }
            temp = temp.next;
        }
        l.next = null; //必须要这句，这是因为当前节点复用的是原链表的节点，而其 next 指针可能指向一个小于x的节点，我们需要切断这个引用
        s.next = largeHead.next;
        return smallHead.next;
    }


}
