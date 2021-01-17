package com.leetcode.Stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 四种解法：查看答案：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 * Author: jingren
 * Date: 2020/12/27
 * Time: 11:37 AM
 */
public class Solution42 {

    public int trap(int[] height) {

        //找到下一个大于等于当前值的位置(两者之间才可能蓄水)，然后计算两者之间的蓄水量
        Stack<Integer> stack = new Stack<>(); //存放下一个高位的位置
        int[] loc = new int[height.length];
        int ans = 0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[i]>=height[stack.peek()]){
                int location = stack.pop();  //该位置的右边的最大元素位置为i；
                if(stack.isEmpty()){
                    break;
                }
                //底
                int distance = i - stack.peek() -1;

                //高
                int high = Math.min(height[i], height[stack.peek()]) - height[location]; //高为最低水位-当前水位  int
                ans += distance * high;

            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] height =  new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Solution42 s = new Solution42();
        s.trap(height);
    }
}
