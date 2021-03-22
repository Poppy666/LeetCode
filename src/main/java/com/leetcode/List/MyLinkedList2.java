package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 707. 设计链表
 * 本解答是单链表实现
 * Author: jingren
 * Date: 2021/3/14
 */
public class MyLinkedList2 {

    private ListNode head;

    private int size;

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public MyLinkedList2() {
        head = new ListNode(0);
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode temp = head;
        int times = 0;
        while (temp!=null){
            if(times == index){
                return temp.val;
            }
            temp = temp.next;
            times++;
        }
        if(index >= times){
            return -1;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        return;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode temp = head;
        while (temp!=null && temp.next!=null){
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        return;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode temp = head;
        int times = 0;
        while (temp!=null){
            if(times == index-1){
                ListNode node =  new ListNode(val);
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
            times++;
        }
        if(index >= times){
            addAtTail(val);
            return;
        }
        return;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode temp = head;
        int times = 0;
        while (temp!=null){
            if(times == index-1){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
            times++;
        }
        return;
    }

}
