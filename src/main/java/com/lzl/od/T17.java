package com.lzl.od;

import java.util.Scanner;

/**
 * 最大坐标值
 */
public class T17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int luckNum = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int i1 = sc.nextInt();
            if (i1 == luckNum) {
                if (i1 < 0) {
                    i1 -= 1;
                } else {
                    i1 += 1;
                }
            }
            sum += i1;
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
