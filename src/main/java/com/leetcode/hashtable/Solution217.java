package com.leetcode.hashtable;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA
 * Project: 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * Author: jingren
 * Date: 2020/11/2
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>(nums.length);
        for(int i:nums){
            if(!hashSet.add(i)){
                return true;
            }
        }
        return false;
    }
}
