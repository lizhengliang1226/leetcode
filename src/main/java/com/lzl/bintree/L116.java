package com.lzl.bintree;

import com.lzl.Node;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * <p>
 * 示例 2:
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * @author lzl
 * @version 1.0
 * @since 2024/12/21
 */
public class L116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next=right;
        traverse(left.left,left.right);
        traverse(right.left,right.right);
        traverse(left.right,right.left);
    }
}
