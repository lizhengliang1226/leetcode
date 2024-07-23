package com.lzl.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最富裕的小家庭
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] wealth = new long[n + 1];
        long[] family = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            int temp = sc.nextInt();
            wealth[i] = temp;
            family[i] = temp;
        }
        for (int i = 1; i <= n - 1; i++) {
            int tf = sc.nextInt();// 父
            int ts = sc.nextInt();// 子
            family[tf] += wealth[ts];
        }
        System.out.println(Arrays.stream(family).max().getAsLong());
    }
}
