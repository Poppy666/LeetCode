package com.leetcode.Queue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 用栈实现队列
 * 思路：直接入栈，出栈过程中调整顺序
 * push操作基于s1，其他操作基于s2
 * 复杂度：push：O(1) 其他pop和peek n次操作均摊后为O(1) 相当于另一种方法，把s1的n-1个数据导入s2,再从s2导回来而言，省去了第二步
 * 因为队列基于链表构成，LinkedList可以两头操作，所以用一个队列就可以模拟栈，实际上如果想要用栈模拟队列，则必须用两个栈才可以。
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/solution/marveljian-dan-de-xue-xi-bi-ji-232-by-marvel_ty/
 * Author: jingren
 * Date: 2020/3/22
 * Time: 4:23 PM
 */
public class Solution232 {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (s2.isEmpty()) {  //该判断可以确保s2中的历史元素先于后加入的s1中的新元素被pop出去
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return  s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (s2.isEmpty()) { //该判断可以确保s2中的历史元素先于后加入的s1中的新元素被peek
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
