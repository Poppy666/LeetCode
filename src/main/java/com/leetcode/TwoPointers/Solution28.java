package com.leetcode.TwoPointers;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Project:给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 输入: haystack = "hello", needle = "ll"   helllo llo
 * 输出: 2
 * Author: jingren
 * Date: 2020/5/18
 * Time: 上午9:35
 */
public class Solution28 {

    public int strStr(String haystack, String needle) {

        if(haystack==null||haystack.length()==0){
            return -1;
        }
        if(needle==null || needle.length()==0){
            return -1;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }

        //Rabin-Karp
        int h = 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {

            h = haystack.charAt(i);
        }

        //KMP





        //定义：空字符串返回0？
        return 0;
    }

//    private int hash(){
//
//    }



}
