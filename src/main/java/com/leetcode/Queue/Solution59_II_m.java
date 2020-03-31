package com.leetcode.Queue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2020/3/31
 * Time: 上午9:41
 */
public class Solution59_II_m {

    LinkedList<Integer> queue = new LinkedList<Integer>();
    Stack<Integer> maxStack = new Stack<>();

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return maxStack.peek();
    }

    public void push_back(int value) {
        if(queue.isEmpty()){
            maxStack.push(value);
        }else {
            maxStack.push(Math.max(maxStack.peek(),value));
        }
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int result = queue.poll();
        maxStack.pop();
        return result;
    }
    
    public static void main(String[] args){
        Solution59_II_m test  = new Solution59_II_m();
        test.push_back(2);
        test.push_back(1);
        test.pop_front();
        System.out.println(test.max_value());
    }
}
