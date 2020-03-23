package com.leetcode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 * Project: 用队列实现栈:使用一个队列
 * 思路：在入队操作里调整顺序，直接出队
 * Author: jingren
 * Date: 2020/3/22
 * Time: 4:05 PM
 */
public class Solution225_useOneQueue {

    Queue<Integer> queue = new LinkedList<Integer>();

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
