package com.lzl.questions;

import com.lzl.util.TreeNode;

/**
 * 104. 二叉树的最大深度
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * @author LZL
 * @version 1.0
 * @since 2023/11/25
 */
public class L104 {
    int dep = 0;

    public int maxDepth(TreeNode root) {
        traverse(root, 1);
        return dep;
    }

    private void traverse(TreeNode root, int curDep) {
        if (root == null) {
            dep = Math.max(dep, curDep);
            return;
        }

        traverse(root.left, curDep + 1);
        traverse(root.right, curDep + 1);
    }
}