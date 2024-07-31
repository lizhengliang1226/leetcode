package com.lzl.od;

import java.io.CharConversionException;
import java.util.Scanner;

/**
 * 求字符串中所有整数的最小和
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int f = 0;
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                if (f == 1) {
                    sb.append(c);
                } else {
                    ans += c - '0';
                }
            } else if (c == '+') {
                if (f == 1 && !sb.isEmpty()) {
                    ans -= Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                    f = 0;
                }
            } else if (c == '-') {
                if (f == 1 && !sb.isEmpty()) {
                    ans -= Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
                f = 1;
            }
        }
        if (!sb.isEmpty()) {
            ans -= Integer.parseInt(sb.toString());
        }
        System.out.println(ans);
    }
}
