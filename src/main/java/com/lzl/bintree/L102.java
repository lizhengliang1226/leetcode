package com.lzl.bintree;

import com.lzl.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 中等
 * 相关标签
 * 相关企业
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/19
 */
public class L102 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder1(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    /**
     * 递归的做法
     *
     * @param root
     * @param dep
     */
    private void dfs(TreeNode root, int dep) {
        if (root == null) {
            return;
        }
        dep++;
        if (res.size() < dep) {
            res.add(new ArrayList<>());
        }
        res.get(dep - 1).add(root.val);
        dfs(root.left, dep);
        dfs(root.right, dep);
    }

    /**
     * 迭代的做法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> r = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                r.add(poll.val);
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }
            res.add(r);
        }
        return res;
    }
}