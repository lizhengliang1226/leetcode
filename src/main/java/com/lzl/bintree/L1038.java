package com.lzl.bintree;

import com.lzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前言
 * 二叉搜索树是一棵空树，或者是具有下列性质的二叉树：
 * <p>
 * 若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * <p>
 * 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * <p>
 * 它的左、右子树也分别为二叉搜索树。
 * <p>
 * 由这样的性质我们可以发现，二叉搜索树的中序遍历是一个单调递增的有序序列。如果我们反序地中序遍历该二叉搜索树，即可得到一个单调递减的有序序列。
 * <p>
 * 方法一：反序中序遍历
 * 思路及算法
 * <p>
 * 本题中要求我们将每个节点的值修改为原来的节点值加上所有大于它的节点值之和。这样我们只需要反序中序遍历该二叉搜索树，记录过程中的节点值之和，
 * 并不断更新当前遍历到的节点的节点值，即可得到题目要求的累加树。
 * <p>
 * 代码
 * <p>
 * C++
 * Java
 * Python3
 * Golang
 * C
 * class Solution {
 * public:
 * int sum = 0;
 * <p>
 * TreeNode* bstToGst(TreeNode* root) {
 * if (root != nullptr) {
 * bstToGst(root->right);
 * sum += root->val;
 * root->val = sum;
 * bstToGst(root->left);
 * }
 * return root;
 * }
 * };
 * 复杂度分析
 * <p>
 * 时间复杂度：O(n)O(n)O(n)，其中 nnn 是二叉搜索树的节点数。每一个节点恰好被遍历一次。
 * <p>
 * 空间复杂度：O(n)O(n)O(n)，为递归过程中栈的开销，平均情况下为 O(log⁡n)O(\log n)O(logn)，最坏情况下树呈现链状，为 O(n)O(n)O(n)。
 * <p>
 * 方法二：Morris 遍历
 * 思路及算法
 * <p>
 * 有一种巧妙的方法可以在线性时间内，只占用常数空间来实现中序遍历，这种方法由 J. H. Morris 在 1979 年的论文「Traversing Binary Trees Simply and Cheaply」中首次提出。
 * 因此被称为 Morris 遍历。
 * <p>
 * Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其反序中序遍历规则总结如下：
 * <p>
 * 如果当前节点的右子节点为空，处理当前节点，并遍历当前节点的左子节点；
 * <p>
 * 如果当前节点的右子节点不为空，找到当前节点右子树的最左节点（该节点为当前节点中序遍历的前驱节点）；
 * <p>
 * 如果最左节点的左指针为空，将最左节点的左指针指向当前节点，遍历当前节点的右子节点；
 * <p>
 * 如果最左节点的左指针不为空，将最左节点的左指针重新置为空（恢复树的原状），处理当前节点，并将当前节点置为其左节点；
 * <p>
 * 重复步骤 1 和步骤 2，直到遍历结束。
 * <p>
 * 这样我们利用 Morris 遍历的方法，反序中序遍历该二叉搜索树，即可实现线性时间与常数空间的遍历。
 * <p>
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 1038. 从二叉搜索树到更大和树
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * <p>
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 * <p>
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 100] 范围内。
 * 0 <= Node.val <= 100
 * 树中的所有值均 不重复 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/04
 */
public class L1038 {
    public static void main(String[] args) {
      /*
      *
        TreeNode n4 = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3);
        TreeNode n8 = new TreeNode(8);
        n4.left=n1;
        n4.right=n6;
        n1.left=n0;
        n1.right=n2;
        n2.right=n3;
        n6.left=n5;
        n6.right=n7;
        n7.right=n8;
       */
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n3.left = n2;
        n2.left = n1;
        n3.right = n4;
        L1038 l1038 = new L1038();
        TreeNode x = l1038.bstToGst(n3);
        System.out.println(x);
    }

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.right);
        return root;
    }

}