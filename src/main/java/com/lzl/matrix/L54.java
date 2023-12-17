package com.lzl.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/17
 */
public class L54 {
    public static void main(String[] args) {
        System.out.println(new L54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new L54().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        boolean[][] used = new boolean[m][n];
        int i = 0, j = 0;
        int size = m * n;
        int index = 0;
        while (res.size() < size) {
            res.add(matrix[i][j]);
            used[i][j] = true;
            int ti = i + dir[index][0];
            int tj = j + dir[index][1];
            if (ti > m - 1 || ti < 0 || tj > n - 1 || tj < 0 || used[ti][tj]) {
                index = ++index == 4 ? 0 : index;
                ti = i + dir[index][0];
                tj = j + dir[index][1];
            }
            i = ti;
            j = tj;
        }
        return res;
    }
}
