package com.lzl.bintree;

import com.lzl.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2415. 反转二叉树的奇数层
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。
 * <p>
 * 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。
 * 反转后，返回树的根节点。
 * <p>
 * 完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。
 * <p>
 * 节点的 层数 等于该节点到根节点之间的边数。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/15
 */
public class L2415 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);
        TreeNode t15 = new TreeNode(15);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left=t8;
        t4.right=t9;
        t5.left=t10;
        t6.left=t12;
        t5.right=t11;
        t6.right=t13;
        t7.left=t14;
        t7.right=t15;
        TreeNode treeNode = new L2415().reverseOddLevels1(t1);
        System.out.println(treeNode);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left,root.right,true);
        return root;
    }

    /**
     * 深度优先遍历，当到偶数层时交换子节点
     * @param left
     * @param right
     * @param isOdd
     */
    private void dfs(TreeNode left, TreeNode right, boolean isOdd) {
        if(left==null){
            return;
        }
        if(isOdd){
            // 这里替换的不是当前节点的左右子树，而是最左和最右节点的子树
            int t=left.val;
            left.val=right.val;
            right.val=t;
        }
        // 这样遍历到叶子的时候，交换两个元素时就可以像双指针一样替换最左和最右的两个
        // 注意，左的左，右的右
        dfs(left.left,right.right,!isOdd);
        // 左的右，右的左
        dfs(left.right,right.left,!isOdd);

    }

    /**
     * 广度优先遍历，遍历得到每层的节点后，使用双指针替换值，比较慢
     * @param root
     * @return
     */
    public TreeNode reverseOddLevels1(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isOdd = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> a = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (poll.left != null) {
                    q.offer(poll.left);
                    q.offer(poll.right);
                }
                if (!isOdd) {
                    a.add(poll);
                }
            }
            if (isOdd) {
                isOdd = false;
                continue;
            }
            for (int left = 0, right = a.size() - 1; left < right; left++, right--) {
                TreeNode l1 = a.get(left);
                TreeNode r1 = a.get(right);
                int t = l1.val;
                l1.val = r1.val;
                r1.val = t;
            }
            isOdd = true;
        }
        return root;
    }
}