package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：
 给定一个链表: 1->2->3->4->5, 和 n = 2.
 当删除了倒数第二个节点后，链表变为 1->2->3->5.

 说明：

 给定的 n 保证是有效的。

 进阶：
 你能尝试使用一趟扫描实现吗？

 思路一：倒数第n个节点就是正数第len-n+1个节点。需要注意的就是删除第一个节点的边界情况。
 遍历两遍的时候，第一遍先获取链表长度，第二遍的时候删除节点。
 思路二：使用双指针，
 * Author: jingren
 * Date: 2021/1/17
 * Time: 5:39 PM
 */
public class Solution19 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        //length-n+1
        ListNode t = head;
        int i = 1;
        if(i==length-n+1){
            return head.next;
        }
        while(t!=null && i!=length-n){  //1,2,3
            t = t.next;
            i++;
        }

        if(t!=null && t.next!=null){
            t.next = t.next.next;
        }

        return head;
    }




}
