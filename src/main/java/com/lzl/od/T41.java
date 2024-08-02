package com.lzl.od;

import java.util.Scanner;

/**
 * 字符串变换最小字符串
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/02
 */
public class T41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        String minString = new String(chars);
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] < chars[i]) {
                    char t = chars[i];
                    chars[i] = chars[j];
                    chars[j] = t;
                    String s1 = new String(chars);
                    if (minString.equals("")) {
                        minString = s1;
                    } else if (s1.compareTo(minString) < 0) {
                        minString = s1;
                        chars[j] = chars[i];
                        chars[i] = t;
                    }
                }
            }
        }
        System.out.println(minString);
    }
}