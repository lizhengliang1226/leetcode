package com.lzl.matrix;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/17
 */
public class L73 {
    public static void main(String[] args) {
        new L73().setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        new L73().setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (used[i][j]) {
                    continue;
                }
                if (num != 0) {
                    continue;
                }
                // 扩散
                diffusion(matrix, i, j, used, 15, m, n);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
    private void diffusion(int[][] matrix, int i, int j, boolean[][] used, int dir, int m, int n) {
        int upi = i;
        int downi = i;
        int leftj = j;
        int rightj = j;
        while (upi >= 0 || downi <= m - 1 || leftj >= 0 || rightj <= n - 1) {
            if (upi >= 0 && matrix[upi][j] != 0) {
                matrix[upi][j] = 0;
                used[upi][j] = true;
            }
            if (downi <= m - 1 && matrix[downi][j] != 0) {
                matrix[downi][j] = 0;
                used[downi][j] = true;
            }
            if (leftj >= 0 && matrix[i][leftj] != 0) {
                matrix[i][leftj] = 0;
                used[i][leftj] = true;
            }
            if (rightj <= n - 1 && matrix[i][rightj] != 0) {
                matrix[i][rightj] = 0;
                used[i][rightj] = true;
            }
            upi--;
            downi++;
            leftj--;
            rightj++;
        }
    }
}
