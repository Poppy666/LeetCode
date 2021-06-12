package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Project: 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 思路一：用hash表，把元素的位置存起来，遍历的时候判断
 * 思路二：用散列表来维护这个k大小的滑动窗口。如果当前散列表的大小超过了 kk， 删除散列表中最旧的元素。
 * 参考https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
 * Author: jingren
 * Date: 2020/11/2
 */
public class Solution219 {

    //思路一
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer value = map.get(nums[i]);
            if(value!=null){
                if(i-value<=k){
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
