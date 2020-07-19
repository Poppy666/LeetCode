package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 21. 合并两个有序链表 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：思路：双指针
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 时间复杂度：O(n+m) 空间复杂度：O(n+m)
 * Author: jingren
 * Date: 2020/7/19
 * Time: 11:27 AM
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1==null?l2:l1;
        return preHead.next;
    }

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

}
