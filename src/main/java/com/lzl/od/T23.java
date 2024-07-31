package com.lzl.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求最多可以派出多少支团队
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            a[i] = m;
        }
        int min = sc.nextInt();
        int count = 0;
        Arrays.sort(a);
        int left = 0;
        int right = n - 1;
        while (a[right--] >= min) {
            count++;
        }

        while (left <= right) {
            if (a[left] + a[right] >= min) {
                count++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        System.out.println(count);
    }
}