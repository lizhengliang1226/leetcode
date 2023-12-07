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

    public int minReorder(int n, int[][] connections) {
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
        dfs(0, -1, tree, map);
        return count;
    }

    int count = 0;

    private int dfs(int cur, int fa, List<Integer>[] tree, Map<Integer, Set<Integer>> dir) {
        for (Integer sub : tree[cur]) {
            if (sub != fa) {
                int son = dfs(sub, cur, tree, dir);
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