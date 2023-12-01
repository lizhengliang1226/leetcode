package com.lzl.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 2661. 找出叠涂元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
 * <p>
 * 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
 * <p>
 * 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/01
 */
public class L2661 {
    public static void main(String[] args) {
        System.out.println(new L2661().firstCompleteIndex(new int[]{8,2,4,9,3,5,7,10,1,6}, new int[][]{new int[]{8,2,9,10,4}, new int[]{1,7,6,3,5}}));
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] pos = new int[m * n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 此处为何乘n得到坐标，而不是从m和n随便选一个？
                pos[mat[i][j]] = i * n + j;
            }
        }
        int[] row = new int[m];
        int[] col = new int[n];
        // 此处为什么是除以n而不是从n和m随便选一个？
        // 有个公式，此处在计算行索引，行索引的最大值不能大于行数吧，也就是m，而数字取值的最大值是m*n，则有
        // m*n/x<=m
        // 解得x>=n 所以x只能取n，如果取m则在m<n时就会越界
        for (int i = 0; i < m * n; i++) {
            // 每行全涂满了则是等于列数n，每列全涂满了则是等于行数m
            if (++row[pos[arr[i]] / n] == n || ++col[pos[arr[i]] % n] == m) {
                return i;
            }
        }
        return -1;
    }

    public int firstCompleteIndex1(int[] arr, int[][] mat) {
        // 每行或每列最后被填满的那个格子对应的索引一定是最大的，所以
        // Map<Integer,int[]> des=new HashMap<>();
        int[][] pos = new int[10000][2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            map.put(i1, i);
        }
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        int rowMin = Integer.MAX_VALUE;
        int colMin = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                // des.put(mat[i][j],new int[]{i,j});
                int index = mat[i][j];
                mat[i][j] = map.get(index);
                // pos[index][1]=j;
                row[i] = Math.max(mat[i][j], row[i]);
                col[j] = Math.max(mat[i][j], col[j]);
                if (i == mat.length - 1) {
                    // 最后一行
                    colMin = Math.min(colMin, col[j]);
                }
            }
            rowMin = Math.min(rowMin, row[i]);
        }
        return Math.min(colMin, rowMin);

    }
}