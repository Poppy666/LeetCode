package com.leetcode.all;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Project: 自己没有想到滑动窗口法，而且HashMap里存储的是位置，不是次数
 * Author: jingren
 * Date: 2019/8/21
 * Time: 下午7:23
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < n; j++) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j+1);
            } else{
                i = map.get(s.charAt(j));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "ahdaefwfecdcel";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring(s));
    }
}
