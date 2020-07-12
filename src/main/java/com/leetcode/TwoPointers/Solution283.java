package com.leetcode.TwoPointers;

/**
 * Created with IntelliJ IDEA
 * Project: 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 输入: [0,1,0,3,12]  输出: [1,3,12,0,0]
 * 思路：遍历数组，将数组的非0元素往前移，剩下的位置用来填充0元素（这里会遍历两遍，更优的解法是一遍解决问题）
 * Author: jingren
 * Date: 2020/7/7
 * Time: 下午7:40
 */
public class Solution283 {

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public void moveZeroes_method2(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {  //它避免了数组开头是非零元素的交换也就是阻止（i==j）时交换。
                    nums[j] = nums[i]; //这里也把交换操作换成了赋值操作，减少了一条操作语句，理论上能更节省时间。
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        Solution283 s = new Solution283();
        s.moveZeroes(nums);
    }
}
