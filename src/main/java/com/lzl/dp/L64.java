package com.lzl.dp;

/**
 * 64. 最小路径和
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/06
 */
public class L64 {
    public static void main(String[] args) {
        System.out.println(new L64().minPathSum(new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}}));
    }

    int min = Integer.MAX_VALUE;

    /**
     * 动态规划：
     * 以终点为起点，假设dp[i][j]是一个起点到终点的最小路径和，那么dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j]，因为只能向右或者向下走，所以等于子结果中的最小值加上自身
     * 倒序遍历整个数组，以每个元素为起点，使用以上公式计算其到终点的最小路径和，遍历完成后返回dp[0][0]即为题目要求的答案
     * 特殊处理，对于最后一行和最后一列，可以直接初始化，因为没有路可走
     * base case，终点不需要走，直接赋值，xy为数组的行数和列数 dp[x - 1][y - 1] = grid[x - 1][y - 1];
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int x = grid.length;//2
        int y = grid[0].length;//3
        int[][] dp = new int[x][y];
        // 目标值直接赋值
        dp[x - 1][y - 1] = grid[x - 1][y - 1];
        // 对于最后一行和最后一列，没有路可以走了，直接初始化即可
        for (int col = y - 2; col >= 0; col--) {
            dp[x - 1][col] = dp[x - 1][col + 1] + grid[x - 1][col];
        }
        for (int row = x - 2; row >= 0; row--) {
            dp[row][y - 1] = dp[row + 1][y - 1] + grid[row][y - 1];
        }
        // 倒序遍历数组，i行j列元素到终点的最小路径和为，[i+1,j]和[i,j+1]这两个元素到终点的最小路径和中的较小值，也就是他右边和下面的那两个元素
        for (int i = x - 2; i >= 0; i--) {
            for (int j = y - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    /**
     * 回溯，超时版本
     *
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int x = grid.length - 1;
        int y = grid[0].length - 1;
        dfs1(0, 0, grid, x, y, grid[0][0]);
        return min;
    }

    private void dfs1(int i, int j, int[][] grid, int x, int y, int sum) {
        if (i == x && j == y) {
//            sum += grid[i][j];
            min = Math.min(sum, min);
            return;
        }
        if (i == x) {
            // 到底了
            dfs1(i, j + 1, grid, x, y, sum + grid[i][j + 1]);
            return;
        }
        if (j == y) {
            // 到右边了
            dfs1(i + 1, j, grid, x, y, sum + grid[i + 1][j]);
            return;
        }
        dfs1(i + 1, j, grid, x, y, sum + grid[i + 1][j]);
        dfs1(i, j + 1, grid, x, y, sum + grid[i][j + 1]);
    }
}
