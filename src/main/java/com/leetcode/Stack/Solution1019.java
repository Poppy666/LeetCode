package com.leetcode.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2020/12/26
 * Time: 10:35 PM
 */
public class Solution1019 {

    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        Stack<Integer> stack = new Stack<>(); //存下标
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            while(!stack.isEmpty() && list.get(i) > list.get(stack.peek())){
                Integer value = stack.pop();
                result[value]=list.get(i);
            }
            stack.push(i);
        }
        return result;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
