package com.leetcode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 * Project:  用队列实现栈:使用一个队列
 * 思路：直接入队，在出队操作里调整顺序
 * 思路：将装载元素中的队列的前n-1都依次移出然后重新入队，最后一个元素直接取出返回
 * Author: jingren
 * Date: 2020/3/21
 * Time: 5:08 PM
 */
public class Solution225 {

    Queue<Integer> queue = new LinkedList<Integer>();

    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        int res = queue.poll();   //本行以及后面的代码不能替换成list.peek(),因为这样的话，在执行pop方法的时候，又会反转顺序
        queue.add(res); //上面把前面几个元素的顺序都反转了一遍，这行代码再把顺序变成原来的顺序
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
    
    public static void main(String[] args){
        Solution225 solution225 = new Solution225();
        solution225.push(1);
        solution225.push(2);
        System.out.println(solution225.top());
        System.out.println(solution225.pop());
        System.out.println(solution225.pop());
        System.out.println(solution225.empty());
    }
}
