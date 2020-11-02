package com.leetcode.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Project: 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:

 s = "abaccdeff"
 返回 "b"

 s = ""
 返回 " "
 * Author: jingren
 * Date: 2020/11/2
 */
public class Solution_Offer_50 {

    public char firstUniqChar(String s) {

        Map<Character, Integer> result = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (result.containsKey(s.charAt(i))) {
                result.put(s.charAt(i), result.get(s.charAt(i)) + 1);
            } else {
                result.put(s.charAt(i), 1);
            }
        }
        for(Map.Entry<Character, Integer> entry:result.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return ' ';
    }
}
