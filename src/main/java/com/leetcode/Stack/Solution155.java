package com.leetcode.Stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 最小栈
 * push、pop和min操作的时间复杂度为O(1)
 * https://leetcode-cn.com/problems/min-stack/solution/java-jian-ji-wu-fu-zhu-zhan-by-rabbitzhao-2/
 * Author: jingren
 * Date: 2020/3/23
 * Time: 下午3:00
 */
public class Solution155 {

    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
