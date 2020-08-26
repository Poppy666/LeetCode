package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 编写一个函数，检查输入的链表是否是回文的。
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 同Solution234
 * 思路：将链表的后半部分反转
 * Author: jingren
 * Date: 2020/8/16
 * Time: 4:06 PM
 */
public class Solution02_06 {

    public boolean isPalindrome(ListNode head) {

        if(head==null){
            return false;
        }
        return false;


    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
