package com.leetcode.Queue;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Project: 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * Author: jingren
 * Date: 2020/3/27
 * Time: 下午5:23
 */
public class Solution59_II {

    LinkedList<Integer> queue = new LinkedList<Integer>();
    int max = Integer.MIN_VALUE;

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return max;
    }

    public void push_back(int value) {
        if (value >= max) {
            queue.add(max);
            max = value;
        }
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int result = queue.poll();
        if (result == max) {
            max = queue.poll();
        }
        return result;
    }

}
