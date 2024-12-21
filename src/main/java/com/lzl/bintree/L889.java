package com.lzl.bintree;

import com.lzl.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * <p>
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [1], postorder = [1]
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= preorder.length <= 30
 * 1 <= preorder[i] <= preorder.length
 * preorder 中所有值都 不同
 * postorder.length == preorder.length
 * 1 <= postorder[i] <= postorder.length
 * postorder 中所有值都 不同
 * 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历
 *
 * @author lzl
 * @version 1.0
 * @since 2024/12/22
 */
public class L889 {
    private Map<Integer, Integer> nodeIndexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            nodeIndexMap.put(postorder[i], i);
        }
        return build(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] postorder, int prs, int pre, int pes, int pee) {
        if (prs > pre) {
            return null;
        }
        if (prs == pre) {
            return new TreeNode(preorder[prs]);
        }
        int rootVal = preorder[prs];
        int leftRootVal = preorder[prs + 1];
        Integer lRootIndex = nodeIndexMap.get(leftRootVal);
        int leftSize = lRootIndex - pes + 1;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, postorder, prs + 1, prs + leftSize, pes, lRootIndex);
        root.right = build(preorder, postorder, prs + leftSize + 1, pre, lRootIndex + 1, pee - 1);
        return root;
    }
}
