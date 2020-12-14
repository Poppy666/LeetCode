package com.leetcode.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 根据数字二进制下 1 的数目排序
 * Author: jingren
 * Date: 2020/11/30
 */
public class Solution1356 {

    public int[] sortByBits(int[] arr) {

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int x = count(o1);
                int y = count(o2);
                if (x != y) {
                    return x-y;
                } else {
                    return o1 - o2;
                }
            }
        });
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        return arr;

    }

    private int count(int num) {
        int count = 0;
        int temp = num;
        while (temp != 0) {
            count += temp & 1;
            temp = temp >>> 1;
        }
        return count;
    }
}
