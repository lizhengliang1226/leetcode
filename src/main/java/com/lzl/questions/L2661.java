package com.lzl.questions;

/**
 * 2661. 找出叠涂元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
 *
 * 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
 *
 * 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
 * @author lzl
 * @version 1.0
 * @since 2023/12/01
 */
public class L2661 {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // Map<Integer,int[]> des=new HashMap<>();
        int[][] pos=new int[10000][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                // des.put(mat[i][j],new int[]{i,j});
                int index = mat[i][j];
                pos[index][0]=i;
                pos[index][1]=j;
            }
        }

        int[] row=new int[mat.length];
        int[] col=new int[mat[0].length];
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            int x = pos[i1][0];
            int y = pos[i1][1];
            // int[] ints = des.get(i1);
            row[x]++;
            if(row[x]==col.length)return i;
            col[y]++;
            if(col[y]==row.length)return i;
        }
        return -1;
    }
}