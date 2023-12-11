package com.lzl.dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1631. 最小体力消耗路径
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
 * 一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/11
 */
public class L1631 {
    public static void main(String[] args) {
        System.out.println(new L1631().minimumEffortPath(new int[][]{new int[]{1, 2, 2}, new int[]{3, 8, 2}, new int[]{5, 3, 5}}));
    }

    int[][] dir = new int[][]{new int[]{-1, 0}, new int[]{0, -1}, new int[]{1, 0}, new int[]{0, 1}};

    /**
     * 二分查找，枚举0-999999（就是题目给的范围），认为这就是最短距离，然后去看有没有比这个更短的，如果有，就更新最短距离
     * 广度优先遍历，得到上下左右四个方向的距离，取比当前mid小于等于的
     * 结束之后，如果右下角的访问标志为真，则找到了一条路径，记录此时的mid为ans，缩小上界，没找到则缩小下界
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0;
        int right = 999999;
        Deque<int[]> q = new LinkedList<>();
        int ans=0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[] start = new int[]{0, 0};
            boolean[][] visited = new boolean[m][n];
            q.offer(start);
            visited[0][0] = true;
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int x = poll[0];
                int y = poll[1];
                for (int i = 0; i < 4; i++) {
                    int xx = x + dir[i][0];
                    int yy = y + dir[i][1];
                    if (xx >= 0 && xx < m && yy >= 0 && yy < n && !visited[xx][yy] && Math.abs(heights[x][y] - heights[xx][yy]) <= mid) {
                        q.offer(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            if (visited[m - 1][n - 1]) {
                ans=mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }


}