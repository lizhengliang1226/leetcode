package com.lzl.bintree;

import java.util.ArrayList;
import java.util.List;

/**
 * 2477. 到达首都的最少油耗
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
 * <p>
 * 每个城市里有一个代表，他们都要去首都参加一个会议。
 * <p>
 * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
 * <p>
 * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
 * <p>
 * 请你返回到达首都最少需要多少升汽油。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/05
 */
public class L2477 {
    /**
     * 贪心+深度优先搜索
     * 贪心：我要计算我到父节点最少要多少油，则尽可能等到我的全部子节点都到我这了，我们再一起坐车
     * 深度优先：一直往下遍历子节点，直到底部，然后一步一步返回路径上的总节点数，到达父节点后统一计算
     * @param roads
     * @param seats
     * @return
     */
    public long minimumFuelCost(int[][] roads, int seats) {
        // 节点数，等于路的条数加一，例如一条路，那肯定是2个节点
        int roadNum = roads.length;
        // 所以这里加一
        List<Integer>[] tree = new List[roadNum + 1];
        // 初始化
        for (int i = 0; i < roadNum + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        // 生成那棵搜索树，具体操作是遍历所有的路，路的两端就是两个节点，对于trr[i]，代表的是i节点有哪些可达的子节点，所以是个List<Integer>，可能有多个
        // 因为是双向的，所以要添加两次，把0和1都当做父节点添加
        for (int[] road : roads) {
            tree[road[0]].add(road[1]);
            tree[road[1]].add(road[0]);
        }
        // 深度优先遍历该多叉树，初始为0，代表从0这个节点开始向下遍历
        dfs(0, -1, tree, seats);
        return res;
    }

    long res = 0;

    private int dfs(int cur, int fa, List<Integer>[] tree, int seats) {
        // 子节点数，因为要返回给自己的父节点，初始化为1，代表自己
        int subPeople = 1;
        for (Integer sub : tree[cur]) {
            // 只有不是父的子节点才会遍历，因为初始化的时候是双向的，会出现有的子节点的trr[i]里面有自己额父节点，此处防止遍历自己的父节点
            if (sub != fa) {
                // 递归遍历自己的每个孩子，得到所有孩子的子节点数
                int subPeoples = dfs(sub, cur, tree, seats);
                // 加上自己，得到当前节点下所有的子节点数，也就是人数
                subPeople += subPeoples;
                // 计算孩子节点到当前节点要多少油，加到总数里面
                // 公式(a+b-1)/b是一个公式，用来对a/b的值向上取整，因为当人数与座位数不整除时，剩余的人要独占一辆车，所以要向上取整
                res += (subPeoples + seats - 1) / seats;
            }
        }
        // 返回自己孩子数，给到父节点去计算
        return subPeople;
    }
}