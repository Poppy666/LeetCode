package com.leetcode.TwoPointers;

/**
 * Created with IntelliJ IDEA
 * Project: 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 思路：在于起始元素的选取，只能选最左下角或右上角中的元素，因为和这两个元素进行比较可以排除一行或一列；
 * 而不能选取最左上角和最右下角的元素，因为其他因素都分别这两个元素小、大；
 * 时间复杂度：O(n+m),空间复杂度：O(1)
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Author: jingren
 * Date: 2020/7/13
 * Time: 上午9:46
 */
public class Solution_Offer_04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int num = matrix[row][col];
            if (target == num) {
                return true;
            } else if (target < num) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
