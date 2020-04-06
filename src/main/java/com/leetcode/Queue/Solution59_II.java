package com.leetcode.Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 * Project: 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 思路：维护一个单边队列和双端队列；单边队列用于存储元素，双端队列用于依次存储最大值，最大值从队头出，队尾出队用于调整下一个最大值
 * 入队：如果当前进入的值比上一个最大值大，则把上一个最大值从队尾移除，把当前值从队尾push进去
 * 出队：如果移出的是最大值，则双端队列也需要移出当前的最大值
 * Author: jingren
 * Date: 2020/3/27
 * Time: 下午5:23
 */
public class Solution59_II {

    Queue<Integer> que = new LinkedList<>();
    Deque<Integer> deq = new LinkedList<>();

    public int max_value() {
        return deq.size()>0?deq.peek():-1;  //双端队列的队首为que的最大值
    }

    public void push_back(int value) {
        que.offer(value);  //value入队
        while(deq.size()>0 && deq.peekLast()<value){
            deq.pollLast();  //将deq队尾小于value的元素删掉
        }
        deq.offerLast(value);  //将value放在deq队尾
    }

    public int pop_front() {
        int tmp = que.size()>0?que.poll():-1;  //获得队首元素
        if(deq.size()>0 && tmp==deq.peek()){
            deq.poll();  //如果出队的元素是当前最大值，将deq的队首出队
        }
        return tmp;
    }
}
