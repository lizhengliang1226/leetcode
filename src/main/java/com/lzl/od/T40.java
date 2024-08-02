package com.lzl.od;

import java.util.Scanner;

/**
 * 考勤信息
 * 2
 * present
 * present absent present present leaveearly present absent*
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/01
 */
public class T40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            Em em = new Em(s);
            if (em.hasLx == 0) {
                sb.append("true ");
            } else {
                sb.append("false ");
            }
        }
        System.out.println(sb.toString());

    }

    private static class Em {
        int a;
        int hasLx;

        public Em(String s) {
            String[] split = s.split(" ");
            int count = 0;
            int y = 0;
            int u = 0;
            int p = 0;
            for (int i = 0; i < split.length; i++) {
                count++;
                String s1 = split[i];
                if (s1.equals("absent")) {
                    a++;
                    p++;
                } else if (s1.equals("late")) {
                    if (i > 0 && split[i - 1].equals("late")) {
                        hasLx = 1;
                    }
                    y++;
                } else if (s1.equals("leaveearly")) {
                    if (i > 0 && split[i - 1].equals("leaveearly")) {
                        hasLx = 1;
                    }
                    u++;
                }
                if (count % 7 == 0) {
                    if (y > 3 || u > 3 || p > 3) {
                        hasLx = 1;
                    }
                    y = 0;
                    u = 0;
                    p = 0;
                }
            }
            if (a > 1) {
                hasLx = 1;
            }
        }
    }
}