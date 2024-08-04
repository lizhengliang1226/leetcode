package com.lzl.od;

import java.util.Scanner;

/**
 * 字符串序列判定
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String l = sc.nextLine();
        char[] sch = s.toCharArray();
        char[] lch = l.toCharArray();
        int r = 0;
        int res = -1;
        int f = 0;
        for (int i = 0; i < sch.length; i++) {
            char c = sch[i];
            for (int j = r; j < lch.length; j++) {
                char c1 = lch[j];
                if (c == c1) {
                    res = j;
                    r = j + 1;
                    if (i == sch.length - 1) {
                        f = 1;
                    }
                    break;
                }
            }
        }
        if (f == 1) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }
}
