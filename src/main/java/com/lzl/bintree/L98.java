package com.lzl.bintree;

import com.lzl.util.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/20
 */
public class L98 {
    public static void main(String[] args) {
        //546nn37
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3);
        TreeNode t7 = new TreeNode(7);
        t5.left = t4;
        t5.right = t6;
        t6.left = t3;
        t6.right = t7;
        System.out.println(new L98().isValidBST(t5));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) return true;
        return root.val > left && root.val < right && isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }
}