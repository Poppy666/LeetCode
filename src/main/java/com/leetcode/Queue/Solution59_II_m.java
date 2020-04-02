package com.leetcode.Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2020/3/31
 * Time: 上午9:41
 */
public class Solution59_II_m {

    Queue<Integer> que;
    Deque<Integer> deq;

    public Solution59_II_m() {
        que = new LinkedList<>();  //队列：插入和删除
        deq = new LinkedList<>();  //双端队列：获取最大值
    }

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

    public static void main(String[] args){
        Solution59_II_m test  = new Solution59_II_m();
        test.push_back(2);
        test.push_back(1);
        test.pop_front();
        System.out.println(test.max_value());
    }
}
