package com.leetcode.string;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2021/5/11
 */
public class Solution_Offer_58 {

    public String reverseLeftWords(String s, int n) {
        if(s==null || s.length()==0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String a = s.substring(0,n);
        String b = s.substring(n,s.length());
        return sb.append(b).append(a).toString();
    }
}
