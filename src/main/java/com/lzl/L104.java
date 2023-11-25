package com.lzl;

/**
 * 104. 二叉树的最大深度
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @author LZL
 * @version 1.0
 * @since 2023/11/25
 */
public class L104 {
    int dep=0;
    public int maxDepth(TreeNode root) {
        return dfs1(root);
//        return dep;
    }

    private int dfs1(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=dfs1(root.left);
        int right=dfs1(root.right);
        return Math.max(left,right)+1;
    }


    private void dfs(TreeNode root, int i) {
        if(root==null){
            dep=Math.max(dep,i);
            return ;
        }
        i++;
        dfs(root.left, i);
        dfs(root.right, i);
        i--;
    }


}
