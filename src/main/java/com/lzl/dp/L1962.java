package com.lzl.dp;

import java.util.PriorityQueue;

/**
 * 1962. 移除石子使总数最小
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 piles ，数组 下标从 0 开始 ，其中 piles[i] 表示第 i 堆石子中的石子数量。另给你一个整数 k ，请你执行下述操作 恰好 k 次：
 *
 * 选出任一石子堆 piles[i] ，并从中 移除 floor(piles[i] / 2) 颗石子。
 * 注意：你可以对 同一堆 石子多次执行此操作。
 *
 * 返回执行 k 次操作后，剩下石子的 最小 总数。
 *
 * floor(x) 为 小于 或 等于 x 的 最大 整数。（即，对 x 向下取整）。
 * @author lzl
 * @version 1.0
 * @since 2023/12/23
 */
public class L1962 {
    public static void main(String[] args) {
        new L1962().minStoneSum(new int[]{5, 4, 9}, 2);
    }

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < piles.length; i++) {
            q.add(piles[i]);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = q.poll();
            poll = poll - poll / 2;
            q.add(poll);
        }
        int sum = 0;
        while (!q.isEmpty()) sum += q.poll();
        return sum;
    }
}
