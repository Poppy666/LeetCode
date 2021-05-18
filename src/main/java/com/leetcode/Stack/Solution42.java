package com.leetcode.Stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * //什么情况下才能装雨水？->左边和右边都比自己高时->什么情况下雨水装得最多？->对自己而言，左边最高的那个位置和右边最高的那个位置->实际装雨水的量怎么算->当然是以短板为准，因此是雨水的高度是min(左边最高，右边最高)
 * //思路：分别从左遍历和从右遍历记录当前位置，左右两侧的高位，在这过程中叠加雨水
 *
 * 四种解法：查看答案：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 * 原则：对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
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

    //双指针
    public int trap2(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

//    public int trap3(int[] height) {
//        int n = height.length;
//        int left = 0;
//        int right = n - 1;
//        int leftMax = Integer.MIN_VALUE;
//        int rightMax = Integer.MIN_VALUE;
//        int result = 0;
//        while (left < right) {
//            if (height[left] >= leftMax) {
//                result += (height[left] - leftMax);
//                leftMax = height[left];
//            }
//            left++;
//            if (height[right] >= rightMax) {
//                result += height[right] - rightMax;
//                rightMax = height[right];
//            }
//            right--;
//        }
//        return result;
//    }

    //直接法
    public int trap3(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

}
