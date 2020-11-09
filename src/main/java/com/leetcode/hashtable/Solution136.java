package com.leetcode.hashtable;


import java.util.HashSet;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA
 * Project: 136. 只出现一次的数字
 * Author: jingren
 * 法一：异或 法二：hashSet，但是空间复杂度为O(n)
 * Date: 2020/11/4
 * Time: 9:20 PM
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            result^=nums[i];
        }
        return result;

    }

    public static int singleNumber_2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                set.remove(nums[i]);
        }
        return Optional.of(set.stream().findFirst()).get().orElse(0);
    }
    
    public static void main(String[] args){
        int[] nums = new int[]{2,2,1};
        int i = singleNumber_2(nums);
        System.out.println(i);
    }



}
