package com.leetcode.all;

import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA
 * Project:
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

}
