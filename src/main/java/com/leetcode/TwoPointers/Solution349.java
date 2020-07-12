package com.leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 349. 两个数组的交集 给定两个数组，编写一个函数来计算它们的交集。
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * Author: jingren
 * Date: 2020/7/8
 * Time: 上午9:42
 */
public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        return list.stream().distinct().mapToInt(Integer::intValue).toArray();
    }

}
