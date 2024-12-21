package com.lzl.util;

import java.util.Random;

/**
 * 树工具类
 *
 * @author lzl
 * @version 1.0
 * @since 2024/12/20
 */
public class TreeUtils {
    static int index;
static Random random = new Random();
    public static TreeNode buildTree(int n) {
//        if (postorder == null || postorder.length == 0) {
//            return null;
//        }
      TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i + 1); // 节点值从1开始递增
        }

        for (int i = 0; i < n; i++) {
            if (2 * i + 1 < n) {
                nodes[i].left = nodes[2 * i + 1];
            }
            if (2 * i + 2 < n) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }

        return nodes[0];
    }

    private static TreeNode buildTreeHelper(int[] postorder, int minValue, int maxValue) {
        if (index < 0 || postorder[index] < minValue || postorder[index] > maxValue) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[index--]);
        root.right = buildTreeHelper(postorder, root.val, maxValue);
        root.left = buildTreeHelper(postorder, minValue, root.val);

        return root;
    }
    /**
     * 打印二叉树的图形表示
     * @param root 根节点
     */
    public static void printTree(TreeNode root) {
        printTree(root, 0, "Root: ");
    }

    private static void printTree(TreeNode node, int level, String prefix) {
        if (node == null) {
            return;
        }

        // 打印当前节点
        System.out.println(" ".repeat(level * 4) + prefix + node.val);

        // 递归打印左子树
        if (node.left != null) {
            printTree(node.left, level + 1, "L--- ");
        }

        // 递归打印右子树
        if (node.right != null) {
            printTree(node.right, level + 1, "R--- ");
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode = buildTree(20);
        printTree(treeNode);
    }
}
