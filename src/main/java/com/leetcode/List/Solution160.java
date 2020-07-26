package com.leetcode.List;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA
 * Project: 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * 思路一：哈希表法，遍历链表 A 并将每个结点的地址/引用存储在哈希表中。然后检查链表 B 中的每一个结点
 * 是否在哈希表中。若在，则节点为相交结点。但是该方法的内存复杂度也为O(n)
 * <p>
 * 思路二：相交说明必然有同一个尾节点。（a + c + b + c = b + c + a + c ，其中，c为公共部分，a，b分别为两个链表在交点之前的部分）
 * A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，所以遍历A+B和遍历B+A一定是同时结束。 如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点 如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
 * <p>
 * Author: jingren
 * Date: 2020/7/26
 * Time: 5:15 PM
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    //使用哈希表的做法
    public ListNode getIntersectionNode_two(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        ListNode q = headB;
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = q.next;
        }
        return null;
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
