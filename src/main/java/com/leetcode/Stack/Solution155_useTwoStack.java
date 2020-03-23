package com.leetcode.Stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 最小栈
 * 思路：用两个栈，一个栈专门存放最小的那个数据
 * Author: jingren
 * Date: 2020/3/23
 * Time: 下午5:32
 */
public class Solution155_useTwoStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        if (stack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
        stack.push(x);
    }

    public void pop() {

        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args){
        Solution155_useTwoStack test = new Solution155_useTwoStack();
        test.push(6);
        test.push(6);
        test.push(7);
        System.out.println(test.top());  //7
        test.pop();
        System.out.println(test.getMin());  //6
        test.pop();
        System.out.println(test.getMin());  //6
        test.pop();   //
        test.push(7);
        System.out.println(test.top());
        System.out.println(test.getMin());
        test.push(8);
        System.out.println(test.top());
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.getMin());
    }
}
