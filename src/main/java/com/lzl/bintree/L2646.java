package com.lzl.bintree;

import java.util.ArrayList;
import java.util.List;

/**
 * 2646. 最小化旅行的价格总和
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
 * <p>
 * 每个节点都关联一个价格。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价格。
 * <p>
 * 给定路径的 价格总和 是该路径上所有节点的价格之和。
 * <p>
 * 另给你一个二维整数数组 trips ，其中 trips[i] = [starti, endi] 表示您从节点 starti 开始第 i 次旅行，并通过任何你喜欢的路径前往节点 endi 。
 * <p>
 * 在执行第一次旅行之前，你可以选择一些 非相邻节点 并将价格减半。
 * <p>
 * 返回执行所有旅行的最小价格总和。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/06
 */
public class L2646 {
    public static void main(String[] args) {
        System.out.println(new L2646().minimumTotalPrice(4, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}}, new int[]{2, 2, 10, 6},
                                                         new int[][]{new int[]{0, 3}, new int[]{2, 1}, new int[]{2, 3}}));
    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        // 初始化树
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        // 求每个节点被经过的次数
        int[] count = new int[n];
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int start = trip[0];
            int end = trip[1];
            // 把每次旅行起始点当做根节点，深度优先遍历所有的子树
            dfs(start, -1, end, count, tree);
        }
        // dp[node][0]代表全价的node节点需要的钱，dp[node][1]代表半价的需要的钱
        // 从0作为根节点开始深度优先遍历，由于相邻的节点只能有一个半价，则有
        // 全价：dp[node][0]=Math.min(dp[sub][0],dp[sub][1])   因为父节点是全价，所以等于子节点的全价和半价较小的那个
        // 半价：dp[node][1]=dp[sub][0]; 因为父节点半价，则子节点只能取全价的
        // 全价价格：price[node]*count[node]  半价：price[node]*count[node] /2（题目说价格一定是偶数，直接/2）
        int[] res = dp(0, -1, count, price, tree);
        // 最后取Math.min(dp[node][0],dp[node][1])
        return Math.min(res[0], res[1]);

    }

    private int[] dp(int cur, int fa, int[] count, int[] price, List<Integer>[] tree) {
        // 计算当前节点全价和半价的价格
        int[] p = new int[]{count[cur] * price[cur], count[cur] * price[cur] / 2};
        // 遍历自己的孩子，计算他们的全价和半价价格
        for (Integer node : tree[cur]) {
            if (node != fa) {
                // 孩子计算完成返回后
                int[] subP = dp(node, cur, count, price, tree);
                // 自己的全价取孩子的全价和半价中较小的那个，然后加上自身
                p[0] += Math.min(subP[0], subP[1]);
                // 自己的半价取孩子的全价，因为半价的不能相邻
                p[1] += subP[0];
            }
        }
        return p;
    }

    private boolean dfs(int start, int fa, int end, int[] count, List<Integer>[] tree) {
        // 到达目的地，经过数加一，返回true，告知父节点经过了目的地，让父节点也加一
        if (start == end) {
            count[start]++;
            return true;
        }
        for (int sub : tree[start]) {
            if (sub != fa) {
                // 遍历每个孩子，根据孩子是否经过目的地
                if (dfs(sub, start, end, count, tree)) {
                    // 经过则自身加一，因为孩子经过了，父节点必经过
                    count[start]++;
                    return true;
                }
            }
        }
        // 对于未经过目的地的子树，返回false
        return false;
    }
}