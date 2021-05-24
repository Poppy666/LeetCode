package com.leetcode.all;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * Project: 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * 示例 1：
 输入: s1 = "ab" s2 = "eidbaooo"
 输出: True
 解释: s2 包含 s1 的排列之一 ("ba").
 示例 2：

 输入: s1= "ab" s2 = "eidboaoo"
 输出: False
 * Author: jingren
 * Date: 2020/11/29
 */
public class Solution567 {

    public boolean checkInclusion(String s1, String s2) {
        if(s2.contains(s1) || s2.contains(StringUtils.reverse(s1))){
            return true;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int n = s1.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < n; i++) {
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }

        //避免漏掉a，ab这种情况
        if(Arrays.equals(c1, c2)){
            return true;
        }

        for (int i = 1; i+n-1 < s2.length(); i++) {
            //第i-1个元素移出去了，第n个元素移进来了
            c2[s2.charAt(i-1)-'a']--;
            c2[s2.charAt(i+n-1)-'a']++;
            if(Arrays.equals(c1, c2)){
                return true;
            }
        }
        return false;
    }

//    public boolean checkInclusion2(String s1, String s2) {
//        if (s2.length() < s1.length()) {
//            return false;
//        }
//        int n = s1.length();
//        int[] c1 = new int[26];
//        int[] c2 = new int[26];
//        for (int i = 0; i < n; i++) {
//            c1[s1.charAt(i)-'a']++;
//            c2[s2.charAt(i)-'a']++;
//        }
//
//        //避免漏掉a，ab这种情况
//        if(Arrays.equals(c1, c2)){
//            return true;
//        }
//
//        for (int i = 1; i+n-1 < s2.length(); i++) {
//            //第i-1个元素移出去了，第n个元素移进来了
//            //只要这两个元素相同，则说明数量没变
//            if (s2.charAt(i - 1)-'a' == s2.charAt(i + n - 1)-'a') {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "eidbaooo";

        Solution567 s = new Solution567();
        boolean result = s.checkInclusion2(s1, s2);
    }


}
