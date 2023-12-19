package com.lzl.bintree;

import com.lzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/19
 */
public class L94 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}