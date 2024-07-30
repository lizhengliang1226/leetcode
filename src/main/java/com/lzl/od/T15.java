package com.lzl.od;

import java.util.Scanner;

/**
 * 素数之积
 */
public class T15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int fc1 = i;
                int fc2 = n / i;
                if (isSushu(fc1) && isSushu(fc2)) {
                    System.out.println(fc1 + " " + fc2);
                    return;
                }
            }
        }
        System.out.println("-1 -1");
    }

    public static boolean isSushu(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
