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
        dfs(a, team, 0, 0, sum, used);
        System.out.println(min);
    }

    private static void dfs(int[] a, int[] team, int start, int dep, int sum, boolean[] used) {
        if (dep == 5) {
            int s = team[0] + team[1] + team[2] + team[3] + team[4];
            int b = Math.abs(sum - s);
            min = Math.min(min, b);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                team[dep] = a[i];
                used[i] = true;
                dfs(a, team, start + 1, dep + 1, sum, used);
                used[i] = false;
            }
        }
    }
}