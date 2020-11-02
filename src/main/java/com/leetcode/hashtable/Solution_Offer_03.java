package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Project: 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 请找出数组中任意一个重复的数字。

 示例 1：

 输入：
 [2, 3, 1, 0, 2, 5, 3]
 输出：2 或 3
 * Author: jingren
 * Date: 2020/11/2
 */
public class Solution_Offer_03 {

    public int findRepeatNumber(int[] nums) {

        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            if(result.containsKey(nums[i])){
                return nums[i];
            }else {
                result.put(nums[i],1);
            }
        }
        return 0;

    }

}
