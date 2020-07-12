package com.leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Project: 350. 两个数组的交集 II 给定两个数组，编写一个函数来计算它们的交集。
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 思路：用map存储较小的数组及出现次数，然后遍历较大数组，判断元素是否存在
 * 进阶：当两个数组有序时，直接采用双指针，见intersect_method2。
 * Author: jingren
 * Date: 2020/7/8
 * Time: 上午9:46
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect_method2(int[] nums1, int[] nums2) {
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
