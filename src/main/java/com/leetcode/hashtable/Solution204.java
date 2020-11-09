package com.leetcode.hashtable;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA
 * Project: 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。

  

 示例 1：

 输入：n = 10
 输出：4
 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。


 * Author: jingren
 * Date: 2020/11/6
 * Time: 10:23 PM
 */
public class Solution204 {

    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        BitSet bit=new BitSet(n);
        for(int i=2;i*i<n;i++){
            if(!bit.get(i)){
                for(int j=i*i;j<n;j+=i){
                    bit.set(j);
                }
            }
        }
        return n-2-bit.cardinality();//排除n和1

    }
}
