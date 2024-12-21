package com.lzl.questions;

import com.lzl.util.TreeNode;

/**
 * 543. 二叉树的直径
 * 简单
 * 相关标签
 * 相关企业
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class L543 {
    int maxD(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lm = maxD(node.left);
        int rm = maxD(node.right);
        int curD = lm + rm + 1;
        return Math.max(lm, rm) + 1;
    }

    public static void main(String[] args) {
        L543 l543 = new L543();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        node5.left = node6;
        node2.right = node7;
        node7.right = node8;
        node8.right = node9;
        node9.right = node10;
        l543.diameterOfBinaryTree(node1);
    }

    int maxD = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxD;
    }

    /**
     * 返回root这颗子树的最大深度
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 取得这个子树的左子树的最大深度
        int leftMaxDep = maxDepth(root.left);
        // 取得这个子树右子树的最大深度
        int rightMaxDep = maxDepth(root.right);
        // 取最大值+1，得到当前子树的最大深度返回
        int curMaxDep = Math.max(leftMaxDep, rightMaxDep) + 1;
        int curD = leftMaxDep + rightMaxDep;
        this.maxD = Math.max(this.maxD, curD);
        return curMaxDep;
    }
}