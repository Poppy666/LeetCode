package com.leetcode.Stack;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Project:
 * 思路：maxInd记录每次最大值的下标，max记录最大值
 * 判断最大值下标是否在滑动窗口的范围内，如果不在就重新寻找当前窗口最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/bu-shi-yong-shu-ju-jie-gou-shuang-100-by-sun-239/
 * Author: jingren
 * Date: 2020/3/28
 * Time: 下午1:06
 */
public class Solution59_I_method3 {

    int max = Integer.MIN_VALUE;

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        int j = 0;
        int n = 0; //记录滑出的位置
        int maxInd = -1; //记录最大值下标
        for (int i = 0; i < k; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxInd = i;
            }
        }
        result[j++] = max;
        for (int i = k; i < nums.length; i++) {
            if (maxInd <= n || maxInd > i) {
                //滑过了最大值，需要重新找最大值
                max = Integer.MIN_VALUE;
                for (int m = n + 1; m <= i; m++) {
                    if (nums[m] >= max) {
                        max = nums[m];
                        maxInd = m;
                    }
                }
            } else {
                if (nums[i] >= max) {
                    max = nums[i];
                    maxInd = i;
                }
            }
            n++;
            result[j++] = max;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution59_I_method3 test = new Solution59_I_method3();
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        int[] result = test.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

}
