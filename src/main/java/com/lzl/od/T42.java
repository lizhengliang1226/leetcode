package com.lzl.od;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 小华最多能得到多少克黄金
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/02
 */
public class T42 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[][] canVi = new boolean[m][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (getSum(i) + getSum(j) <= k) {
        //             //安全
        //             canVi[i][j] = true;
        //         }
        //
        //     }
        // }
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visi = new boolean[m][n];
        if (0 <= k) {
            visi[0][0] = true;
            q.offer(new int[]{0, 0});
        }
        // if (canVi[0][0]) {
        //     visi[0][0] = true;
        //     q.offer(new int[]{0, 0});
        // }
        int max = 0;
        int[][] dir = new int[][]{new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            max++;
            for (int[] d : dir) {
                int x = poll[0] + d[0];
                int y = poll[1] + d[1];
                // if (x >= 0 && x < m && y >= 0 && y < n && !visi[x][y] &&canVi[x][y]) {
                if (x >= 0 && x < m && y >= 0 && y < n && !visi[x][y] && getSum(x) + getSum(y) <= k) {
                    q.offer(new int[]{x, y});
                    visi[x][y] = true;
                }
            }
        }
        System.out.println(max);
    }

    public static int getSum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}