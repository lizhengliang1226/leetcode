package com.lzl.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 多段线数据压缩
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < array.length; i += 2) {
            a.add(new int[]{array[i], array[i + 1]});
        }
        List<int[]> b1 = new ArrayList<>();
        for (int i = 0; i < a.size() - 2; i++) {
            int[] p1 = a.get(i);
            int[] p2 = a.get(i + 1);
            int[] p3 = a.get(i + 2);
            int[] v = hasZhuazhe(p1, p2, p3);
            if (v != null) {
                b1.add(v);
            }
        }
        b1.add(0, a.get(0));
        b1.add(a.get(a.size() - 1));
        for (int[] ints : b1) {
            System.out.print(ints[0] + " " + ints[1] + " ");
        }
    }

    private static int[] hasZhuazhe(int[] p1, int[] p2, int[] p3) {
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];
        int x3 = p3[0];
        int y3 = p3[1];
        int i = x2 - x1;
        int i1 = y2 - y1;
        int j = x3 - x2;
        int j1 = y3 - y2;
        if (i != j || i1 != j1) {
            return p2;
        } else {
            return null;
        }

    }
}
