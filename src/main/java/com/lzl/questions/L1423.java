package com.lzl.questions;

import java.util.Arrays;

/**
 * 1423. 可获得的最大点数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * <p>
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * <p>
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * <p>
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/03
 */
public class L1423 {
    public static void main(String[] args) {
        System.out.println(new L1423().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }

    private int max = 0;

    public int maxScore(int[] cardPoints, int k) {
        // 滑动窗口：获取剩余卡牌的最小值，然后用数组的总值减去这个最小值就得到了最大值
        int left = 0;
        int right = 0;
        int n = cardPoints.length;
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        if (k == n) {
            return sum;
        }
        int winSize = n - k;
        int winVal = 0;
        int minVal = Integer.MAX_VALUE;
        while (right < n) {
            int rightVal = cardPoints[right];
            winVal += rightVal;
            while (right - left == winSize - 1) {
                minVal = Math.min(minVal, winVal);
                winVal -= cardPoints[left];
                left++;
            }
            right++;
        }
        return sum - minVal;
    }


    /**
     * 第一种解法，回溯，但是会超时
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore1(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if (k == n) {
            return Arrays.stream(cardPoints).reduce(Integer::sum).getAsInt();
        }
        int sum = 0;
        dfs1(cardPoints, n, sum, k, 0, 0, n - 1);
        return max;
    }

    private void dfs1(int[] cardPoints, int n, int sum, int k, int dep, int start, int end) {
        if (dep == k) {
            max = Math.max(sum, max);
            return;
        }
        if (start <= end) {
            sum += cardPoints[start];
            dfs1(cardPoints, n, sum, k, dep + 1, start + 1, end);
            sum -= cardPoints[start];
            sum += cardPoints[end];
            dfs1(cardPoints, n, sum, k, dep + 1, start, end - 1);
            sum -= cardPoints[end];
        }
    }
}
