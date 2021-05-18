package com.leetcode.Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 * Project: 滑动窗口的最大值:使用队列
 * 思路：用队列存储窗口元素，滑动的时候比较滑入值和最大值的大小，更新最大值；
 * 但是如果最大值被滑出了队列，则需要重新找队列最大值
 * 关键在于，需要一个队列维护窗口内元素的最大值队列，最大值移出的时候，对最大值队列进行更新
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * Author: jingren
 * Date: 2020/3/27
 * Time: 下午4:57
 */
public class Solution59_I {

    Queue<Integer> queue = new LinkedList<>();
    int max = Integer.MIN_VALUE;

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
            queue.add(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        int j = 0;
        result[j++] = max;
        for (int i = k; i < nums.length; i++) {

            queue.add(nums[i]);
            if (queue.poll() == max) {
                //滑过了最大值，需要重新找最大值
                max = Integer.MIN_VALUE;
                for (int q : queue) {
                    max = Math.max(max, q);
                }
            } else {
                max = Math.max(max, nums[i]);
            }
            result[j++] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution59_I test = new Solution59_I();
        int[] nums = new int[]{1, -1};
        int[] result = test.maxSlidingWindow(nums, 1);
        System.out.println(Arrays.toString(result));
    }



//    int max = Integer.MIN_VALUE;
//
//    public int[] maxSlidingWindow2(int[] nums, int k) {
//
//        if (nums == null || nums.length == 0) {
//            return new int[0];
//        }
//
//        int[] result = new int[nums.length - k + 1];
//        int j = 0;
//        int n = 0; //记录滑出的位置
//        int maxInd = -1; //记录最大值下标
//        for (int i = 0; i < k; i++) {
//            if (nums[i] >= max) {
//                max = nums[i];
//                maxInd = i;
//            }
//        }
//        result[j++] = max;
//        for (int i = k; i < nums.length; i++) {
//            if (maxInd <= n || maxInd > i) {
//                //滑过了最大值，需要重新找最大值
//                max = Integer.MIN_VALUE;
//                for (int m = n + 1; m <= i; m++) {
//                    if (nums[m] >= max) {
//                        max = nums[m];
//                        maxInd = m;
//                    }
//                }
//            } else {
//                if (nums[i] >= max) {
//                    max = nums[i];
//                    maxInd = i;
//                }
//            }
//            n++;
//            result[j++] = max;
//        }
//
//        return result;
//    }
}
