package com.leetcode.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 148. 排序链表
 * 输入：head = [4,2,1,3]
   输出：[1,2,3,4]

 进阶：
 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

 思路一：
 思路二：
 * Author: jingren
 * Date: 2020/9/2
 * Time: 下午7:29
 */
public class Solution148 {

    public class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public ListNode sortList(ListNode head) {

        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(list);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }
        return dummy.next;
    }

//    public ListNode sortList2(ListNode head) {
//        if(head == null){
//            return head;
//        }
//
//        ListNode temp = head;
//        int len = 0;
//        while (temp != null) {
//            temp = temp.next;
//            len++;
//        }
//
//
//
//    }
//
////    public ListNode merge(){
////
////    }
//
//    public ListNode sortTwoList(ListNode a, ListNode b){
//        if (a == null || b == null) {
//            return a != null ? a : b;
//        }
//
//        ListNode dummy = new ListNode(0);
//        ListNode temp = dummy;
//        if (a.val <= b.val) {
//            temp.next = a;
//            a.next = b;
////            temp = temp.next;
////            temp.next = b;
//        } else {
//            temp.next = b;
//            b.next = a;
//        }
//        return dummy.next;
//    }



}
