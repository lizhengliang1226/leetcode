package com.lzl.od;

import java.util.Scanner;

/**
 * 数的分解
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int left = 1, right = 2;
        int win = 1;
        int start = 0;
        int end = 0;
        int minL = Integer.MAX_VALUE;
        while (right < n) {
            win += right;
            if (win == n) {
                if (right - left + 1 < minL) {
                    minL = right - left + 1;
                    start = left;
                    end = right;

                }
            }
            right++;
            while (left <= right && win > n) {
                win -= left;
                left++;
                if (win == n) {
                    if (right - 1 - left + 1 < minL) {
                        minL = right - 1 - left + 1;
                        start = left;
                        end = right - 1;
                    }
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(n + "=");
        for (int i = start; i < end; i++) {
            sb.append(i + "+");
        }
        sb.append(end);
        System.out.println(sb.toString());
    }
}