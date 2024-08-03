package com.lzl.od;

import java.util.Scanner;

/**
 * 计算三叉搜索树的高度
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        ThreeTree threeTree = new ThreeTree();

        for (int i = 0; i < N; i++) {
            threeTree.put(sc.nextInt());
        }
        System.out.println(threeTree.height());
    }

    private static class Node {
        Node left, right, mid;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private static class ThreeTree {

        Node root;
        int h = 0;

        public void put(int value) {
            if (root == null) {
                root = new Node(value);
                h++;
                return;
            } else {
                int dir = 0;
                Node p = root;
                Node pp = p;
                while (p != null) {
                    if (value < p.value - 500) {
                        dir = 1;
                        pp = p;
                        p = p.left;
                    } else if (value > p.value + 500) {
                        dir = 2;
                        pp = p;
                        p = p.right;
                    } else {
                        dir = 3;
                        pp = p;
                        p = p.mid;
                    }
                }
                if (dir == 1) {
                    pp.left = new Node(value);
                    if (pp.right == null && pp.mid == null) {
                        h++;
                    }
                } else if (dir == 2) {
                    pp.right = new Node(value);
                    if (pp.left == null && pp.mid == null) {
                        h++;
                    }
                } else if (dir == 3) {
                    pp.mid = new Node(value);
                    if (pp.left == null && pp.right == null) {
                        h++;
                    }
                }
            }
        }

        public int height() {
            return h;
        }
    }
}
