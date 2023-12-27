package com.lzl.questions;

/**
 * 2660. 保龄球游戏的获胜者
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个下标从 0 开始的整数数组 player1 和 player2 ，分别表示玩家 1 和玩家 2 击中的瓶数。
 * <p>
 * 保龄球比赛由 n 轮组成，每轮的瓶数恰好为 10 。
 * <p>
 * 假设玩家在第 i 轮中击中 xi 个瓶子。玩家第 i 轮的价值为：
 * <p>
 * 如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子，则为 2xi 。
 * 否则，为 xi 。
 * 玩家的得分是其 n 轮价值的总和。
 * <p>
 * 返回
 * <p>
 * 如果玩家 1 的得分高于玩家 2 的得分，则为 1 ；
 * 如果玩家 2 的得分高于玩家 1 的得分，则为 2 ；
 * 如果平局，则为 0 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/27
 */
public class L2660 {
    public int isWinner(int[] player1, int[] player2) {
        int n = player2.length;
        int sum1 = 0;
        int sum2 = 0;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < n; i++) {
            int p1 = player1[i];
            int p2 = player2[i];
            sum1 += (index1 != -1 && i - index1 <= 2) ? p1 * 2 : p1;
            index1 = p1 == 10 ? i : index1;
            sum2 += (index2 != -1 && i - index2 <= 2) ? p2 * 2 : p2;
            index2 = (p2 == 10) ? i : index2;
        }
        return sum1 > sum2 ? 1 : sum1 < sum2 ? 2 : 0;
    }
}