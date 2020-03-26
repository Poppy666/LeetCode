package com.leetcode.Stack;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 滑动窗口的最大值
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * Author: jingren
 * Date: 2020/3/24
 * Time: 下午2:46
 */
public class Solution59_I {

    LinkedList queue = new LinkedList();
    LinkedList maxQueue = new LinkedList();
    int max = 0;

    public int[] maxSlidingWindow(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            if(queue.isEmpty()){
                maxQueue.add(nums[i]);
            }else{
                maxQueue.add(Math.max((Integer) maxQueue.getFirst(), nums[i]));
            }
            queue.add(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = k; i < nums.length; i++) {
            int j = 0;
            if (!maxQueue.isEmpty()) {
                result[j++] = (Integer) maxQueue.getFirst();
            }
            queue.add(nums[i]);
            maxQueue.add(Math.max((Integer) maxQueue.getFirst(), nums[i]));
            queue.removeFirst();
            maxQueue.removeFirst();
        }

        return result;
    }
    
    public static void main(String[] args){
        Solution59_I test = new Solution59_I();
        int [] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int [] result = test.maxSlidingWindow(nums, 3);
    }
}
