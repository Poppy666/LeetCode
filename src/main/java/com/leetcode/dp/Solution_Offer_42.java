package com.leetcode.dp;

/**
 * Created with IntelliJ IDEA
 * Project: 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 思路：动态规划
 * 状态定义：dp[i]标识以i结尾的连续子数组的最大和
 * 转移方程：如果dp[i-1]<=0 的话，则对d[i-1]对dp[i]的贡献为负，d[i-1]+num[i]还不如num[i]本身大
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * Author: jingren
 * Date: 2021/5/28
 */
public class Solution_Offer_42 {

    //dp[i]标识以i结尾的连续子数组的最大和。dp[i]=dp[i-1]+num

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    //官方解答
    //将原数组 nums 用作 dp 列表，即直接在 nums 上修改即可,省去 dp 列表使用的额外空间
    //空间复杂度由O(n)变成O(1)
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
