package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 对链表进行插入排序
 * Author: jingren
 * Date: 2020/9/2
 * Time: 下午7:29
 */
public class Solution147 {

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

    public ListNode insertionSortList(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastSoretd = head;
        ListNode curr = head.next;
        while (curr!=null){
           if(curr.val>= lastSoretd.val){   //3,4,6,7,5,9:假设现在到6，则直接把6更新为lastSoretd,
               lastSoretd = lastSoretd.next;
           }else{
               ListNode pre = dummy;               //3,4,6,7,5,9:假设现在到5，需要把5插入进去, 顺序应为 5->6，4->5。如果先是4->5,则这过程6会成为孤立节点
               while (pre.next.val<=curr.val){
                   pre = pre.next;  //最终pre相当于4
               }
               lastSoretd.next = curr.next; // lastSoretd->9
               curr.next = pre.next; //5之后插入6 //这一步是把5->6
               pre.next = curr; //这一步是把4->5，本身5是指向9的，所以5指向6之前，必须把5.next保存起来,所以上上一步是最后一个有序的指向9 ; 由于4之后原本是6，所以在4指向5之前应该先把6处理了
               //如果后两句交换，会指导5指向自己，可以画图

           }
           curr = lastSoretd.next;  //这一步不能是curr = curr.next,因为curr本身已经被插入了，则位置已经发生变化
        }
        return  dummy.next;
    }

}
