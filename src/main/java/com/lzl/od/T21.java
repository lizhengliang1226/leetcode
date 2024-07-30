package com.lzl.od;

import java.util.Scanner;

/**
 * 靠谱的车
 */
public class T21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res=n;
        for (int i = 0; i < n; i++) {
            String s = String.valueOf(i);
            if (s.contains("4")) {
                  res--;
            }
        }
        System.out.println(res);
    }
}
