package com.leetcode.Stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 84. 柱状图中最大的矩形
 * 思路：
 * //矩阵面积最大？什么时候最大？->当然是底和高都尽可能大的时候->两个值都变的话，就不好考虑了->假设高不变，那当然底尽可能长则面积最大->对应当然图而言，对于每根柱子，假设高就是自己的高，那么就底尽可能往两侧延伸，但是如图，往左右延伸的话，可能相邻的柱子高更低，那么自己的高就不再有效了，因此想让自己的高有效，则自己是最低的那个高才会有效->因此本题的核心是找出，以当前值为最小值的范围，而这个范围就是矩形的底长
 * //找出当前值为最小值得范围
 * Author: jingren
 * Date: 2021/3/14
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        //矩阵面积最大？什么时候最大？->当然是底和高都尽可能大的时候->两个值都变的话，就不好考虑了->假设高不变，那当然底尽可能长则面积最大
        // ->对应当然图而言，对于每根柱子，假设高就是自己的高，那么就底尽可能往两侧延伸，但是如图，往左右延伸的话，可能相邻的柱子高更低，那么自己的高就不再有效了，因此想让自己的高有效，则自己是最低的那个高才会有效
        // ->因此本题的核心是找出，以当前值为最小值的范围，而这个范围就是矩形的底长
        //找出当前值为最小值得范围

        /**
         * 为啥以下解答特殊案例无法通过，如[999,999,999,999]
         */
//        int area = 0;
//        Stack<Integer> stack = new Stack<>();
//        int[] left = new int[heights.length];  //记录左边最远大于等于自己的那个位置
//        //int[] right 注：不必再存一遍右边的值，从右往左遍历的时候，直接就可以计算面积了
//        for(int i=0;i<heights.length;i++){
//            int high = heights[i];
//            left[i]= i;
//            while(!stack.isEmpty() && high<=heights[stack.peek()]){
//                left[i]= stack.pop();
//            }
//
//            stack.push(i);
//        }
//        stack.clear();
//
//        for(int i=heights.length-1;i>=0;i--){
//            int high = heights[i];
//            int loc = i;
//            while(!stack.isEmpty() && high<=heights[stack.peek()]){
//                loc = stack.pop();
//            }
//            stack.push(i);
//            int currArea = high*(loc - left[i]+1);
//            area = Math.max(area,currArea);
//        }
//        return area;
        return 0;


    }
}
