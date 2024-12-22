package com.lzl.bintree;

import com.lzl.util.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * 简单
 * 相关标签
 * 相关企业
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * 示例 2:
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 107
 * root 是二叉搜索树
 * 1 <= val <= 107
 *
 * @author Reflect
 * @version 1.0
 * @since 2024/12/22
 */
public class L700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }
}
