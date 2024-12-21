package com.lzl.bintree;

import com.lzl.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 *
 * @author lzl
 * @version 1.0
 * @since 2024/12/22
 */
public class L106 {
    private Map<Integer, Integer> nodeIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            nodeIndexMap.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if (is > ie) {
            return null;
        }
        int num = postorder[pe];
        Integer rootIndex = nodeIndexMap.get(num);
        int leftSize = rootIndex - is;
        TreeNode root = new TreeNode(num);
        root.left = build(inorder, postorder, is, rootIndex - 1, ps, ps + leftSize - 1);
        root.right = build(inorder, postorder, rootIndex + 1, ie, leftSize+ps, pe - 1);
        return root;
    }
}
