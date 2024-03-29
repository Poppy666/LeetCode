package com.leetcode.List;

/**
 * Created with IntelliJ IDEA
 * Project: 707. 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

 在链表类中实现这些功能：

 get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

 提示：

 所有val值都在 [1, 1000] 之内。
 操作次数将在  [1, 1000] 之内。
 请不要使用内置的 LinkedList 库。

 * Author: jingren
 * Date: 2021/3/8
 */
public class MyLinkedList {

//    private ListNode head;
//
//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//
//    /**以下代码是反面教材：
//     * 主要原因在于，addAtHead和addAtTail是addAtIndex的特殊情况，应该考虑addAtIndex的实现方法，然后
//     * 前两者直接调用该方法实现；二是利用size作边界判断*/
//    /** Initialize your data structure here. */
//    public MyLinkedList() {
//        head = new ListNode(0);
//    }
//
//    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
//    public int get(int index) {
//        ListNode temp = head;
//        int times = 0;
//        while (temp!=null){
//            if(times == index){
//                return temp.val;
//            }
//            temp = temp.next;
//            times++;
//        }
//        if(index >= times){
//            return -1;
//        }
//        return -1;
//    }
//
//    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
//    public void addAtHead(int val) {
//        ListNode newHead = new ListNode(val);
//        newHead.next = head;
//        return;
//    }
//
//    /** Append a node of value val to the last element of the linked list. */
//    public void addAtTail(int val) {
//        ListNode temp = head;
//        while (temp!=null && temp.next!=null){
//            temp = temp.next;
//        }
//        temp.next = new ListNode(val);
//        return;
//    }
//
//    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
//    public void addAtIndex(int index, int val) {
//        ListNode temp = head;
//        int times = 0;
//        while (temp!=null){
//            if(times == index-1){
//                ListNode node =  new ListNode(val);
//                node.next = temp.next;
//                temp.next = node;
//                return;
//            }
//            temp = temp.next;
//            times++;
//        }
//        if(index >= times){
//            addAtTail(val);
//            return;
//        }
//        return;
//    }
//
//    /** Delete the index-th node in the linked list, if the index is valid. */
//    public void deleteAtIndex(int index) {
//        ListNode temp = head;
//        int times = 0;
//        while (temp!=null){
//            if(times == index-1){
//                temp.next = temp.next.next;
//                return;
//            }
//            temp = temp.next;
//            times++;
//        }
//        return;
//    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}
