package com.lzl.questions;

import java.util.List;

/**
 * 559. N 叉树的最大深度
 * 简单
 * 375
 * 相关企业
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 */
public class L559 {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();


    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        return dfs(root, 1);
    }

    private int dfs(Node root, int dep) {
        int dep1 = -1;
        if (root == null || root.children == null || root.children.size() == 0) {
            return dep;
        }
        for (int i = 0; i < root.children.size(); i++) {
            int dfs = dfs(root.children.get(i), dep + 1);
            dep1 = Math.max(dep1, dfs);
        }
        return dep1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};