package com.lzl.diffarr;

/**
 * 2132. 用邮票贴满网格图
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m x n 的二进制矩阵 grid ，每个格子要么为 0 （空）要么为 1 （被占据）。
 * <p>
 * 给你邮票的尺寸为 stampHeight x stampWidth 。我们想将邮票贴进二进制矩阵中，且满足以下 限制 和 要求 ：
 * <p>
 * 覆盖所有 空 格子。
 * 不覆盖任何 被占据 的格子。
 * 我们可以放入任意数目的邮票。
 * 邮票可以相互有 重叠 部分。
 * 邮票不允许 旋转 。
 * 邮票必须完全在矩阵 内 。
 * 如果在满足上述要求的前提下，可以放入邮票，请返回 true ，否则返回 false 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/14
 */
public class L2132 {
    public static void main(String[] args) {
        System.out.println(new L2132().possibleToStamp(
                new int[][]{new int[]{1, 0, 0, 0}, new int[]{1, 0, 0, 0}, new int[]{1, 0, 0, 0}, new int[]{1, 0, 0, 0}, new int[]{1, 0, 0, 0}}, 4,
                3));
    }

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;
        // 对于差分数组，计算的时候会算到(0,0)之前的行和列，设置值的时候会设置到(m,n)之后的那一行和列，所以初始化时要加2，把会被取到的多的行初始化
        int[][] diff = new int[m + 2][n + 2];
        // 对于前缀和数组，计算时会取之前的行和列，不会取之后的，所以只用加1
        int[][] preSum = new int[m + 1][n + 1];
        // 求出整个表格的前缀和
        // 坐标从(0,0)开始，是为了取到grid的值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 设置值的时候要加1，放到实际的前缀和位置
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + grid[i][j];
            }
        }
        // 从题目指定的宽高位置开始遍历，求每个位置的前缀和，如果为0则代表这块可以填邮票，把差分数组对应的位置加一
        // 把题目给的宽高直接作为坐标，因为本身这个数组计算时就是从坐标1开始计算的
        for (int iEnd = stampHeight; iEnd <= m; iEnd++) {
            for (int jEnd = stampWidth; jEnd <= n; jEnd++) {
                // 此处由结束坐标减去宽高得到起始坐标，之后要加1 ，也是因为数组的坐标现在都是从1开始算的
                int iStart = iEnd - stampHeight + 1;
                int jStart = jEnd - stampWidth + 1;
                // 判断从(iStart,jStart)到(iEnd,jEnd)的前缀和是否为0，如果是，则说明可以填邮票
                if (preSum[iEnd][jEnd] - preSum[iEnd][jStart - 1] - preSum[iStart - 1][jEnd] + preSum[iStart - 1][jStart - 1] == 0) {
                    // 把对应区域的差分数组加1
                    // 左上角
                    diff[iStart][jStart]++;
                    // 右上角
                    diff[iStart][jEnd + 1]--;
                    // 左下角
                    diff[iEnd + 1][jStart]--;
                    // 右下角
                    diff[iEnd + 1][jEnd + 1]++;
                }
            }
        }
        // 遍历差分数组，还原原始数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从0开始遍历，因为要取grid，坐标都加1 ，因为实际坐标是从1开始的
                diff[i + 1][j + 1] += diff[i + 1][j] + diff[i][j + 1] - diff[i][j];
                // 表格的对应位置未被占领，且此时那个位置又没有放邮票，那么未填满
                if (grid[i][j] == 0 && diff[i + 1][j + 1] < 1) {
                    return false;
                }
            }
        }
        return true;
    }
}