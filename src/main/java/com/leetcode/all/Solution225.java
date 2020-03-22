package com.leetcode.all;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 * Project: 用队列实现栈
 * Author: jingren
 * Date: 2020/3/21
 * Time: 5:08 PM
 */
public class Solution225 {

    Queue<Integer> list;

    /** Initialize your data structure here. */
    public Solution225() {
        list = new LinkedList<Integer>();
    }

    public void push(int x) {
        list.add(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(list.poll());
        }
        return list.poll();
    }

    /** Get the top element. */
    public int top() {
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(list.poll());
        }
        int res = list.poll();
        list.add(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.peek() == null ? true : false;
    }
}
