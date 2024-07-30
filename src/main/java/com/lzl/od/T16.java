package com.lzl.od;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * CPU算力分配
 */
public class T16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L1 = sc.nextInt();
        int L2 = sc.nextInt();
        int[] c1 = new int[L1];
        int[] c2 = new int[L2];
        for (int i = 0; i < L1; i++) {
            c1[i] = sc.nextInt();
        }

        for (int i = 0; i < L2; i++) {
            c2[i] = sc.nextInt();
        }
        int suma = 0;
        int sumb = 0;
        for (int i : c1) {
            suma += i;
        }
        for (int i : c2) {
            sumb += i;
        }
        int da = (suma - sumb) / 2;
        Set<Integer> s = new HashSet<>();
        for (int i : c1) {
            s.add(i);
        }
        int minA = Integer.MAX_VALUE;
        int resa = 0;
        int resb = 0;
        for (int i : c2) {
            int a = i + da;
            if (s.contains(a)) {
                if (a < minA) {
                    minA = a;
                    resa = a;
                    resb = i;
                }
            }
        }
        System.out.println(resa + " " + resb);
    }
}
