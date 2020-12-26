package com.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 1539. 第 k 个缺失的正整数
 * Author: jingren
 * 法一：用hash表记录已经存在的数，然后遍历数组找出第k个缺失的正整数
 * 法二：使用双指针分别记录缺失的数量和缺失的数
 * 法三法四：参考https://leetcode-cn.com/problems/kth-missing-positive-number/solution/duo-chong-jie-fa-by-dao-chang-3/
 * Date: 2020/11/15
 * Time: 4:08 PM
 */
public class Solution1539 {

    public int findKthPositive(int[] arr, int k) {

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        List<Integer> list = new ArrayList<>();
        int i=1;
        while(true){
            if(!set.contains(i)){
                list.add(i);
                if(list.size()==k){
                    return list.get(k-1);
                }
            }
            i++;
        }
    }

    public int findKthPositive_2(int[] arr, int k) {

        int missCount = 0;//记录缺失的数量
        int missNum = 0; //记录缺失的那个数
        int curr = 1; //记录当前应该出现的数
        int pos=0; //记录当前访问位置
        for(missCount=0; missCount<k; curr++){
            if(arr[pos]==curr){
                pos = (pos+1) <arr.length?(pos+1):pos;
            }else{
                missCount ++;
                missNum = curr;
            }
        }
        return missNum;
    }





}
