package com.lzl.arrpoint;

/**
 * 1901. 寻找峰值 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 * <p>
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
 * <p>
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 * <p>
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/19
 */
public class L1901 {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int max=Integer.MIN_VALUE;
        int[] res=new int[]{0,0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
              if(mat[i][j]>max){
                  max=mat[i][j];
                  res[0]=i;
                  res[1]=j;
              }
            }
        }
        return res;
    }



    public int[] findPeakGrid1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = mat[i][j];
                int up = getNum(mat, i, j, dir[0], m, n);
                int down = getNum(mat, i, j, dir[1], m, n);
                int left = getNum(mat, i, j, dir[2], m, n);
                int right= getNum(mat, i, j, dir[3], m, n);
                if(cur>up&&cur>down&&cur>left&&cur>right)return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }

    private int getNum(int[][] mat, int i, int j, int[] dir, int m, int n) {
        int upi = i + dir[0];
        int upj = j + dir[1];
        if (upi > m - 1 || upi < 0) {
            return Integer.MIN_VALUE;
        }
        if (upj > n - 1 || upj < 0) {
            return Integer.MIN_VALUE;
        }
        int up = mat[upi][upj];
        return up;
    }
}