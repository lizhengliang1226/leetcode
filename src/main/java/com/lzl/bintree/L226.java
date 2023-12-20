package com.lzl.bintree;

import com.lzl.util.TreeNode;

/**
 * 226. 翻转二叉树
 * 简单
 * 相关标签
 * 相关企业
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/19
 */
public class L226 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        dfs(root.left);
        dfs(root.right);
    }
}