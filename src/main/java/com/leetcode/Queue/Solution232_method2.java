package com.leetcode.Queue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 用栈实现队列
 * 思路：入栈过程中调整顺序，直接出栈
 * 以s2为准，所有操作都是基于s2操作，s1只是充当了调整顺序的辅助栈
 * 复杂度：push：O(n) 其他O(1)
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/solution/marveljian-dan-de-xue-xi-bi-ji-232-by-marvel_ty/
 * Author: jingren
 * Date: 2020/3/22
 * Time: 4:42 PM
 */
public class Solution232_method2 {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s2.isEmpty()){  //确保原本s2中就有元素的时候，先拿出来，等把新元素push进去后再把这些元素push进去
            s1.push(s2.pop());
        }
        s2.push(x);
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s2.isEmpty();
    }
}
