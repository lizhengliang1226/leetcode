package com.lzl.od;

import java.util.Scanner;

/**
 * 找座位
 */
public class T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] seats = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            seats[i] = chars[i] - '0';
        }
        System.out.println(max(seats));
    }

    private static int max(int[] seats) {
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            boolean l = (i == 0) || seats[i - 1] == 0;
            boolean r = (i == seats.length - 1) || seats[i + 1] == 0;
            if (seats[i] == 0 && l && r) {
                res++;
                seats[i] = 1;
            }
        }
        return res;
    }
}
