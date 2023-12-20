package com.lzl.bintree;

import com.lzl.util.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/19
 */
public class L108 {
    public static void main(String[] args) {
        System.out.println(new L108().sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode root = buildTree(nums, 0, n - 1);
        return root;
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }
}