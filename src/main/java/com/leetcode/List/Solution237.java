package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 思路：从链表里删除一个节点 node 的最常见方法是修改之前节点的 next 指针，使其指向之后的节点。因为，我们无法访问我们想要删除的节点 之前 的节点，我们始终不能修改该节点的 next 指针。相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
 因为我们知道要删除的节点不是列表的末尾，所以我们可以保证这种方法是可行的。
 * Author: jingren
 * Date: 2020/7/30
 * Time: 下午7:36
 */
public class Solution237 {
    public void deleteNode(ListNode node) {

        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
