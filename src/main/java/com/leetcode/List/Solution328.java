package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 328. 奇偶链表
 *
 * 思路：用两个指针分别遍历奇数节点和偶数节点，奇数节点的下一个节点即为偶数节点的下一个节点；而偶数节点的下一个节点即为奇数节点的下一个节点，
 * 同时边遍历边更新新的奇数节点和偶数节点
 * Author: jingren
 * Date: 2021/3/7
 * Time: 8:29 PM
 */
public class Solution328 {

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

    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        return head;

    }
}
