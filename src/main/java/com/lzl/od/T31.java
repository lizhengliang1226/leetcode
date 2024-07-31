package com.lzl.od;

import java.util.Scanner;

/**
 * 最多购买宝石数
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int i1 = sc.nextInt();
            a[i] = i1;
        }
        int value = sc.nextInt();
        int left = 0;
        int right = 0;
        int win = 0;
        int max = Integer.MIN_VALUE;
        while (right < n) {
            win += a[right];
            if (win == value) {
                max = Math.max(max, right - left + 1);
            }
            right++;
            while (left < right && win > value) {
                win -= a[left];
                left++;
                if (win == value) {
                    max = Math.max(max, right - left);
                }
            }
        }
        System.out.println(max);
    }
}
