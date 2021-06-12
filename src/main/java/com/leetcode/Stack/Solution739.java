package com.leetcode.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Project: 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

 思路：在栈中存放温度对应的下标值，注意不是温度值。
 每次把当前温度值与栈顶位置对应的温度值做比较，如果更大，则说明是栈顶位置的下一个温度值。则弹出来计算。
 下一次就是弹出后的栈顶位置寻找它的下一个最大温度值。如果当前温度比栈顶位置对应的温度小，则入栈
 注：关键点就在于要不断更新这个值，当找到该位置的下一个更高温度时，要从栈里弹出该位置，这样才能取到放到它之前的位置


 * Author: jingren
 * Date: 2021/3/14
 */
public class Solution739 {

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();  //用来存放当前温度对应的下标值，如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

}
