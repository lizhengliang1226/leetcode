package com.lzl.od;

import java.util.Scanner;

/**
 * 停车场车辆统计
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().trim().split(",");
        int ans = 0;
        // 110011101
        int r = 0;
        while (r < split.length) {
            String s = split[r];
            if (s.equals("0")) {
                r++;
            } else if (s.equals("1")) {
                int f = 1;
                while (r < split.length && split[r].equals("1") && f <= 3) {
                    r++;
                    f++;
                }
                ans++;
            }

        }
        System.out.println(ans);
    }
}
