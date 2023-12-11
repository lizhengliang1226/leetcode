package com.lzl.dp;

/**
 * 1631. 最小体力消耗路径
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
 * 一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/11
 */
public class L1631 {
    public static void main(String[] args) {
        System.out.println(new L1631().min(new int[][]{new int[]{1, 2, 2}, new int[]{3, 8, 2}, new int[]{5, 3, 5}}));
    }

    public int min(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dp = new int[rows][cols];
        // dp[rows - 1][cols - 1] = heights[rows - 1][cols - 1];
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = Math.max(dp[i + 1][cols - 1], Math.abs(heights[i][cols - 1] - heights[i + 1][cols - 1]));
        }
        for (int i = cols - 2; i >= 0; i--) {
            dp[rows - 1][i] = Math.max(dp[rows - 1][i + 1], Math.abs(heights[rows - 1][i] - heights[rows - 1][i + 1]));
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dp[i][j] = getMin(Math.max(dp[i + 1][j], Math.abs(heights[i + 1][j] - heights[i][j])),
                                  Math.max((i - 1 >= 0 ? dp[i - 1][j] : Integer.MIN_VALUE),
                                           Math.abs((i - 1 >= 0 ? heights[i - 1][j] : 0) - heights[i][j])),
                                  Math.max(dp[i][j + 1], Math.abs(heights[i][j + 1] - heights[i][j])),
                                  Math.max((j - 1 >= 0 ? dp[i][j - 1] : Integer.MIN_VALUE),
                                           Math.abs((j - 1 >= 0 ? heights[i][j - 1] : 0) - heights[i][j])));
            }
        }
        return dp[0][0];
    }

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][][] dp = new int[rows][cols][5];
        // dp[rows - 1][cols - 1] = 0;
        // 0.上，1，下，2，左，3，右
        for (int i = rows - 2; i >= 0; i--) {
            int lastColIndex = cols - 1;
            dp[i][lastColIndex][1] = Math.max(dp[i + 1][lastColIndex][1], Math.abs(heights[i][lastColIndex] - heights[i + 1][lastColIndex]));
        }
        for (int i = cols - 2; i >= 0; i--) {
            int lastRowIndex = rows - 1;
            dp[lastRowIndex][i][3] = Math.max(dp[lastRowIndex][i + 1][3], Math.abs(heights[lastRowIndex][i] - heights[lastRowIndex][i + 1]));
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                // 1
                dp[i][j][1] = Math.max(dp[i + 1][j][4], Math.abs(heights[i + 1][j] - heights[i][j]));
                // 0
                dp[i][j][0] = Math.max((i - 1 >= 0 ? dp[i - 1][j][4] : Integer.MIN_VALUE),
                                       Math.abs((i - 1 >= 0 ? heights[i - 1][j] : 0) - heights[i][j]));
                // 3
                dp[i][j][3] = Math.max(dp[i][j + 1][4], Math.abs(heights[i][j + 1] - heights[i][j]));
                // 2
                dp[i][j][2] = Math.max((j - 1 >= 0 ? dp[i][j - 1][4] : Integer.MIN_VALUE),
                                       Math.abs((j - 1 >= 0 ? heights[i][j - 1] : 0) - heights[i][j]));
                dp[i][j][4] = getMin(dp[i][j][0], dp[i][j][0], dp[i][j][0], dp[i][j][0]);
            }
        }
        return dp[0][0][4];
    }

    private int getMin(int a, int b, int c, int d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }


}