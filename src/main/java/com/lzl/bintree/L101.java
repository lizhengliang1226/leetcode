package com.lzl.bintree;

import com.lzl.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/19
 */
public class L101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    /**
     * 递归的写法
     * @param left
     * @param right
     * @return
     */
    private boolean dfs(TreeNode left, TreeNode right) {
        return left == null || right == null ? left == right : (left.val == right.val && (dfs(left.left, right.right) && dfs(left.right,
                                                                                                                             right.left)));
    }

    /**
     * 迭代的写法
     * @param root
     * @return
     */
    private boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }


}