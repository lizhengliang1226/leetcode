package com.lzl.util;

/**
 * @author LZL
 * @version 1.0
 * @since 2023/11/25
 */

public class TreeNode {
    public int val;
    public int size;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}