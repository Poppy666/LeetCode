package com.leetcode.Sort;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2020/12/2
 */
public class Solution1636 {

    public int[] frequencySort(int[] nums) {
        int[] temp = new int[100];
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            temp[i]++;
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (temp[o1] != temp[o1]) {
                    return temp[o1] - temp[o2];
                } else {
                    return o2 - o1;
                }
            }
        });

        //return Arrays.stream(list).mapToInt(Integer::valueOf).toArray();
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer l : list) {
            result[i++] = l;
        }
        return result;

    }

    public int[] frequencySort_2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        //转化为Integer[] 数组
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        //自定义排序
        Arrays.sort(integers, (a, b) -> map.get(a)== map.get(b)? b-a :map.get(a)-map.get(b));

        //转化为int[] 数组
        return Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
    }


}
