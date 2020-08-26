package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 面试题 02.07. 链表相交
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 * intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
 * 思路：参考 Solution160
 *
 * 对于不相交的情况：
 * 不相交，两个指针t1和t2最终走到头，同时等于null，此时退出循环，返回null
 * 如果t1走到头变成null，那岂不是又把崭新的headB赋值给t1重新走了吗
 * 然后就走headB，最终也走到头变成null。t1走了A和B,t2走了B和A,t1和t2走的路程一样，如果不相交最终同时走到null
 * Author: jingren
 * Date: 2020/8/16
 * Time: 3:43 PM
 */
public class Solution02_07 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null || headB==null){
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q ) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;

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
