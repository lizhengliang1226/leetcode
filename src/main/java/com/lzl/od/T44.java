package com.lzl.od;

import java.util.Scanner;

/**
 * 游戏分组
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/02
 */
public class T44 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int i1 = sc.nextInt();
            a[i] = i1;
            sum += i1;
        }
        int[] team = new int[5];
        boolean[] used = new boolean[10];
        dfs(a, used, 0, 0, 0);
        System.out.println(min);
    }

    private static void dfs(int[] a, boolean[] used, int idx, int ts1, int ts2) {
        if (idx == 10) {
            min = Math.min(min, Math.abs(ts1 - ts2));
            return;
        }
        dfs(a, used, idx + 1, ts1, ts2 + a[idx]);
        dfs(a, used, idx + 1, ts1 + a[idx], ts2);
    }
}