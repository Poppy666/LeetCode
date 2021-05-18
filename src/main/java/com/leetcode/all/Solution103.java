package com.leetcode.all;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 103. 二叉树的锯齿形层序遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 给定二叉树 [3,9,20,null,null,15,7],
 返回锯齿形层序遍历如下：
 [
 [3],
 [20,9],
 [15,7]
 ]
 * Author: jingren
 * Date: 2021/5/18
 */
public class Solution103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    }


}
