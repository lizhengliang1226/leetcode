package com.lzl.od;

import java.util.Scanner;

/**
 * 分披萨
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/01
 */
public class T38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int i1 = sc.nextInt();
            if (i1 > max) {
                max = i1;
                sum = i1;
                left = i - 1 >= 0 ? i - 1 : N - 1;
                right = i + 1 > N - 1 ? 0 : i + 1;
            }
            a[i] = i1;
        }
        while (left != right) {
            if (a[left] > a[right]) {
                left = left - 1 >= 0 ? left - 1 : N - 1;
            } else if (a[left] < a[right]) {
                right = right + 1 > N - 1 ? 0 : right + 1;
            }
            if (a[left] > a[right]) {
                sum += a[left];
                left = left - 1 >= 0 ? left - 1 : N - 1;
            } else if (a[left] < a[right]) {
                sum += a[right];
                right = right + 1 > N - 1 ? 0 : right + 1;
            } else if (left == right) {
                sum += a[left];
            }
        }
        System.out.println(sum);
    }
}