package com.leetcode.Sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Project: 给定两个数组，编写一个函数来计算它们的交集。
 * Author: jingren
 * 思路：先将两个数组进行排序，然后用两个指针分别遍历两个数组
 * Date: 2020/4/12
 * Time: 4:05 PM
 */
public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
