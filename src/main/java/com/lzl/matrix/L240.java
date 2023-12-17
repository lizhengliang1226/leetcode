package com.lzl.matrix;

/**
 * 240. 搜索二维矩阵 II
 * 中等
 * 相关标签
 * 相关企业
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/17
 */
public class L240 {
    public static void main(String[] args) {
        System.out.println(new L240().searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
    }

    /**
     * 行和列一起比较缩小范围
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i=m-1,j=0;
        while (i>=0&&j<n){
            if(matrix[i][j]==target){
                return true;
            }
            if(matrix[i][j]<target){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }
    /**
     * 行级二分查找，比较慢
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean find = false;
        for (int i = m-1; i >=0; i--) {
            if (matrix[i][0] <= target && target <= matrix[i][n - 1]) {
                find = binSearch(i, matrix, m, n, target);
                if (find) {
                    return true;
                }
            }
        }
        return find;
    }

    private boolean binSearch(int row, int[][] matrix, int m, int n, int target) {
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
