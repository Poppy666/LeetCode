package com.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 输出：[2]
 示例 2：

 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出：[9,4]
 * Author: jingren
 * Date: 2020/11/2
 */
public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            set1.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums2.length;i++){
            if(set1.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }

        return list.stream().distinct().mapToInt(Integer::intValue).toArray();
    }

}
