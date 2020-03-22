package com.leetcode.Stack;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Project: 用队列实现栈: 用两个队列实现
 * 思路：https://leetcode-cn.com/problems/implement-stack-using-queues/solution/liang-ge-dui-lie-de-shi-xian-ji-bai-liao-10000-de-/
 * 使用两个队列的轮流使用，始终保持一个队列为空。
 （1）push()方法没什么问题，直接添加在空的队列中就好。
 （2）pop()方法在于将装载元素中的队列的前n-1都移到另外一个空队列中（利用size方法），最后一个元素直接取出返回。
 （3）top()方法和pop()方法基本思路一致，只是在前n-1个元素移动后，将最后一个元素赋值，然后在压入队列中去。
 （4）empty()方法直接判断两个队列是否都为空即可。
 * Author: jingren
 * Date: 2020/3/22
 * Time: 3:30 PM
 */
public class Solution225_useTwoQueue {

    LinkedList<Integer> queue1 = new LinkedList<Integer>();
    LinkedList<Integer> queue2 = new LinkedList<Integer>();


    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }

    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        int top = 0;
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            top = queue1.poll();
            queue2.offer(top);
        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            top = queue2.poll();
            queue1.offer(top);
        }
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
