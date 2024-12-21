package com.lzl.bintree;

import com.lzl.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 *
 * @author lzl
 * @version 1.0
 * @since 2024/12/22
 */
public class L105 {

    private final Map<Integer, Integer> nodeIndexMap = new HashMap<>();

    record Pair(int num, int index) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            nodeIndexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        Integer rootIndex = nodeIndexMap.get(preorder[ps]);
        int leftSize = rootIndex - is;
        TreeNode root = new TreeNode(preorder[ps]);
        root.left = build(preorder, inorder, ps + 1, ps + leftSize, is, rootIndex - 1);
        root.right = build(preorder, inorder, ps + leftSize + 1, pe, rootIndex + 1, ie);
        return root;
    }
}
