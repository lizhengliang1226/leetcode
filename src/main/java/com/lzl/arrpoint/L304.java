package com.lzl.arrpoint;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * <p>
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * <p>
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 *
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/10
 */
public class L304 {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }
}

class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length][matrix[0].length];
        preSum[0][0] = matrix[0][0];
        // 列不变，行动，求第一列的所有前缀和
        for (int i = 1; i < matrix.length; i++) {
            preSum[i][0] = preSum[i - 1][0] + matrix[i][0];
        }
        // 行不动，列变，求第一行的前缀和
        for (int i = 1; i < matrix[0].length; i++) {
            preSum[0][i] = preSum[0][i - 1] + matrix[0][i];
        }
        // 遍历，当前和等于前一个和加上自身
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i][j] - preSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // row2,col2所求矩形的右下角坐标
        // row1-1,col2所求矩形的右上角坐标
        //  row2,col1-1所求矩形的左下角坐标
        // row1-1,col1-1所求矩形的左上角坐标
        return preSum[row2][col2] - (row1 - 1 >= 0 ? preSum[row1 - 1][col2] : 0) - (col1 - 1 >= 0 ? preSum[row2][col1 - 1] : 0) + (row1 - 1 >= 0 && col1 - 1 >= 0 ? preSum[row1 - 1][col1 - 1] : 0);
    }
}
