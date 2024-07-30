package com.lzl.od;

import java.util.Scanner;

/**
 * 执行时长
 */
public class T22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bxd = sc.nextInt();
        int n = sc.nextInt();
        int cur = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            int taskNum = sc.nextInt();
            cur += taskNum;
            if (cur > bxd) {
                cur -= bxd;
            } else {
                cur = 0;
            }
            time++;
        }
        while (cur > 0) {
            cur -= bxd;
            time++;
        }
        System.out.println(time);
    }
}
