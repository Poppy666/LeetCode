package com.leetcode.all;

/**
 * Created with IntelliJ IDEA
 * Project: 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

 示例 1：

 输入：nums = [10,9,2,5,3,7,101,18]
 输出：4
 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

 * Author: jingren
 * Date: 2021/5/18
 */
public class Solution300 {

    //dp[i]考虑前i个元素，是以第i个数字结尾的最长子序列，dp[i+1]=dp[i]+1
    //结果就为所有dp[i]中的最大值
    public int lengthOfLIS(int[] nums) {

        int dp[] = new int[nums.length];
        dp[0]=1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                   dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(result,dp[i]);
        }
        return result;

//
//        if (nums.length == 0) {
//            return 0;
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int maxans = 1;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            maxans = Math.max(maxans, dp[i]);
//        }
//        return maxans;


    }

}
