package com.leetcode.Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project:给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 思路：单调栈
 * https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode/
 * Author: jingren
 * Date: 2020/4/2
 * Time: 上午9:35
 */
public class Solution496 {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {

            if(i==0){
                stack.push(nums2[i]);
            }
            while (!stack.empty() && nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()){
            map.put(stack.pop(),-1);
        }
        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            result[i]=map.get(nums1[i]);
        }
        return result;
    }
}
