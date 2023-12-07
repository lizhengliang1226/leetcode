package com.lzl.bintree;

import java.util.*;

/**
 * 1466. 重新规划路线
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * <p>
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * <p>
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * <p>
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * <p>
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/07
 */
public class L1466 {
    public static void main(String[] args) {
        System.out.println(
                new L1466().minReorder(6, new int[][]{new int[]{0, 1}, new int[]{1, 3}, new int[]{2, 3}, new int[]{4, 0}, new int[]{4, 5}}));
    }

    /**
     * 深度优先遍历，多加一个方向的判断，类似dp的思想从叶子节点往上不断求和计算，得到最终结果
     *
     * @param n
     * @param connections
     * @return
     */
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] road : connections) {
            // 正向边用0，反向边用1
            tree[road[0]].add(new int[]{road[1], 0});
            tree[road[1]].add(new int[]{road[0], 1});
        }
        return dfs(0, -1, tree);
    }

    private int dfs(int cur, int fa, List<int[]>[] tree) {
        int sum = 0;
        for (int[] sub : tree[cur]) {
            int son = sub[0];
            int dir = sub[1];
            if (son != fa) {
                // 得到孩子节点需要转变的次数
                int sunRes = dfs(son, cur, tree);
                // 加上自身
                sum += sunRes;
                if (dir == 0) {
                    // 如果当前这个子节点和自己的方向是正向（0），也就是父指向子，此时应该变化方向让子指向父，才能往上走到达0节点
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * 深度优先搜索+Hash表，速度极慢
     *
     * @param n
     * @param connections
     * @return
     */
    public int minReorder1(int n, int[][] connections) {
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] road : connections) {
            tree[road[0]].add(road[1]);
            tree[road[1]].add(road[0]);
            map.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);

        }
        dfs1(0, -1, tree, map);
        return count;
    }

    int count = 0;

    private int dfs1(int cur, int fa, List<Integer>[] tree, Map<Integer, Set<Integer>> dir) {
        for (Integer sub : tree[cur]) {
            if (sub != fa) {
                int son = dfs1(sub, cur, tree, dir);
                boolean contains = dir.getOrDefault(son, new HashSet<>()).contains(cur);
                if (!contains) {
                    dir.computeIfAbsent(son, k -> new HashSet<>()).add(cur);
                    count++;
                }
            }
        }
        return cur;
    }
}