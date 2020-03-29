package com.leetcode.Stack;


import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Project: 滑动窗口的最大值
 * 思路：跟Solution59_I差不多，只是不需要专门的队列来存储窗口元素
 * 这种算法会导致有时候不必要地遍历子序列的大小重找最大值，比如{1,3,3,2,0,5}，k=3,
 * 当第一个最大值3被滑出时，会重新遍历找{3,2,0}中最大值，采用记录更新最大值下标可以避免，详见Solution59_I_method3
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * Author: jingren
 * Date: 2020/3/24
 * Time: 下午2:46
 */
public class Solution59_I_method2 {

    int max = Integer.MIN_VALUE;

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] result = new int[nums.length - k + 1];
        int j = 0;
        result[j++] = max;
        int n = 0;
        for (int i = k; i < nums.length; i++) {
            if (nums[n] == max) {
                //滑过了最大值，需要重新找最大值
                max = Integer.MIN_VALUE;
                for (int m = n + 1; m <= i; m++) {
                    max = Math.max(max, nums[m]);
                }
            } else {
                max = Math.max(max, nums[i]);
            }
            n++;
            result[j++] = max;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution59_I_method2 test = new Solution59_I_method2();
        int[] nums = new int[]{1,3,3,2,0,5};
        int[] result = test.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }
}
