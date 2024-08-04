package com.lzl.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 特殊的加密算法
 * 2
 * 0 3
 * 3
 * 0 0 2
 * 1 3 4
 * 6 6 4*
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T65 {
    public static void main(String[] args) {
        System.out.println("00".compareTo("01"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            int i1 = sc.nextInt();
            a[i] = i1;
        }
        int M = sc.nextInt();
        Map<Integer, int[]> mw = new HashMap<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int finalI = i;
                int finalJ = j;
                mw.compute(sc.nextInt(), (k, v) -> {
                    if (v == null) {
                        return new int[]{finalI, finalJ};
                    } else {
                        if ((v[0] + "" + v[1]).compareTo(finalI + "" + finalJ) > 0) {
                            return v;
                        } else {
                            return new int[]{finalI, finalJ};
                        }
                    }
                });
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            int[] ints = mw.get(a[i]);
            if (ints == null) {
                sb.append("error ");
            } else {
                sb.append(ints[0]).append(" ").append(ints[1]).append(" ");
            }
        }
        System.out.println(sb.toString());

    }
}
