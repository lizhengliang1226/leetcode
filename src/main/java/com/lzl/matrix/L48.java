package com.lzl.matrix;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/17
 */
public class L48 {
    public static void main(String[] args) {
        new L48().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        new L48().rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }

    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int[][] t = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                t[j][m - i - 1] = matrix[i][j];
            }
        }
        System.arraycopy(t, 0, matrix, 0, m);
        System.out.println(Arrays.deepToString(matrix));
    }
}
