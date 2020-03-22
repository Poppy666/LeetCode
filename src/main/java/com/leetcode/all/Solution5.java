package com.leetcode.all;

/**
 * Created with IntelliJ IDEA
 * Project: 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/
 * Author: jingren
 * Date: 2019/8/25
 * Time: 下午5:06
 */
public class Solution5 {

    public static void main(String[] args){
        String s = "cbbaabbf";
        System.out.println(longestPalindrome(s));
    }

    //思路：遍历字符串，把当前元素当成回文串的中间字符，以该字符为基准，分别往左和往右比较
    //以下修正部分，无论怎样调整顺序，都会漏掉一种情况，
    public static String longestPalindrome(String s) {
        if(s.length()<=0){
            return "";
        }
        int minLeft = 0;
        int maxRight = 0;
        int maxLen = 1;
        for(int i=0;i<s.length();i++){
            int left = i-1;
            int right = i+1;
            //先修正左右位置
            if(i>0 && s.charAt(i-1)==s.charAt(i)){
                right = i;
            }
            if(i+1 < s.length() && s.charAt(i+1)==s.charAt(i)){
                left = i;
            }
            if(i>0 && i+1 < s.length() && s.charAt(i-1)==s.charAt(i+1)){
                left = i-1;
                right = i+1;
            }
            int begin = 0;
            int end = 0;
            while(left>=0 && right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    begin = left;
                    end = right;
                    left--;
                    right++;
                }else{
                    break; //这个break特别容易被忽略,没有该break会超时
                }
            }
            int currentLen = end-begin+1;
            if(currentLen>maxLen){
                minLeft = begin;
                maxRight = end;
                maxLen = currentLen;
            }
        }
        return s.substring(minLeft,maxRight+1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return l - r + 1;
    }

    //官方题解
    public String longestPalindrome2(String s) {
        if (s == null || s == "") {
            return "";
        }
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}
