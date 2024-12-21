package com.lzl.bintree;

import com.lzl.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 * 困难
 * 相关标签
 * 相关企业
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 *
 * @author lzl
 * @version 1.0
 * @since 2024/12/22
 */
public class L297 {
}

class Codec {

    // Encodes a tree to a single string.
    public String serializeByPre(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverseByPre(root, sb);
        return sb.delete(sb.lastIndexOf(","), sb.length()).toString();
    }

    private void traverseByPre(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        traverseByPre(root.left, sb);
        traverseByPre(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeByPre(String data) {
        Deque<String> q = new ArrayDeque<>();
        for (String s : data.split(",")) {
            q.addLast(s);
        }
        return buildByPre(q);
    }

    private TreeNode buildByPre(Deque<String> s) {
        String rootVal = s.removeFirst();
        if (rootVal.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = buildByPre(s);
        root.right = buildByPre(s);
        return root;
    }

    public String serializeByPost(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverseByPost(root, sb);
        return sb.delete(sb.lastIndexOf(","), sb.length()).toString();
    }

    private void traverseByPost(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        traverseByPost(root.left, sb);
        traverseByPost(root.right, sb);
        sb.append(root.val).append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeByPost(String data) {
        Deque<String> q = new ArrayDeque<>();
        for (String s : data.split(",")) {
            q.addLast(s);
        }
        return buildByPost(q);
    }

    private TreeNode buildByPost(Deque<String> s) {
        if (s.isEmpty()) {
            return null;
        }
        String rootVal = s.removeLast();
        if (rootVal.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.right = buildByPost(s);
        root.left = buildByPost(s);
        return root;
    }

    public String serializeByHierarchical(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append("null,");
                    continue;
                }
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.delete(sb.lastIndexOf(","), sb.length()).toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserializeByHierarchical(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.addLast(root);
        int index = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                String leftVal = nodes[index++];
                if (!leftVal.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(leftVal));
                    q.addLast(node.left);
                }
                String rightVal = nodes[index++];
                if (!rightVal.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(rightVal));
                    q.addLast(node.right);
                }
            }
        }
        return root;
    }


}
