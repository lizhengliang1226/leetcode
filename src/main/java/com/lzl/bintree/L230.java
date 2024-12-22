package com.lzl.bintree;

import com.lzl.util.TreeNode;

/**
 * 230. 二叉搜索树中第 K 小的元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 * @author lzl
 * @version 1.0
 * @since 2024/12/22
 */
public class L230 {
    private int res = 0;
    private int r = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        r++;
        if (r == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
