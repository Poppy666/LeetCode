package com.leetcode;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA
 * Project: 利用Guava的BloomFilter
 * Author: jingren
 * Date: 2021/4/4
 */
public class BoomFilterDemo {

    public static void main(String[] args){
        //初始化一个存储string数据的布隆过滤器，初始化大小1000w,不能设置为0
        BloomFilter bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 10000000, 0.01);
        String test = "test1";
        System.out.println(test + "是否在列表中： " + bloomFilter.mightContain(test));
        bloomFilter.put(test);
        System.out.println(test + "是否在列表中： " + bloomFilter.mightContain(test));
        test = "test2";
        System.out.println(test + "是否在列表中： " + bloomFilter.mightContain(test));

    }
}
