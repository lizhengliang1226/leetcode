package com.lzl.bintree;


import com.lzl.bintree.util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 *
 * @author lzl
 * @version 1.0
 * @since 2024/02/19
 */
public class L590 {
    public static void main(String[] args) {
        new L590().postorder(new Node());
    }
    public List<Integer> postorder(Node root) {
        root.val = 1;
        List<Node> n1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Node n = new Node();
            n.val = i;
            List<Node> u = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                Node m = new Node();
                m.val = j + 80;
                u.add(m);
            }
            n.children = u;
            n1.add(n);
        }
        root.children = n1;
        dfs(root);
        return null;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        for (int i = 0;  root.children!=null&&i < root.children.size(); i++) {
            Node node = root.children.get(i);
            dfs(node);
        }
        System.out.println(root.val);
    }
}