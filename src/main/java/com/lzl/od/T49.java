package com.lzl.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 灰度图恢复
 * 10 10 255 34 0 1 255 8 0 3 255 6 0 5 255 4 0 7 255 2 0 9 255 21
 * 3 4
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = a[0];
        int n = a[1];
        int h = 0;
        int v = 0;
        int[][] d = new int[m][n];
        for (int i = 2; i < a.length; i += 2) {
            int hd = a[i];
            int num = a[i + 1];
            int s = 0;
            while (s < num) {
                s++;
                if (v < n) {
                    d[h][v] = hd;
                    v++;
                } else {
                    h++;
                    if (h < m) {
                        d[h][0] = hd;
                        v = 1;
                    }
                }
            }
        }
        String s = sc.nextLine();
        int[] array = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(d[array[0]][array[1]]);
    }
}
