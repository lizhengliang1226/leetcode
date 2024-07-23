package com.lzl.od;

import java.util.Scanner;

/**
 * 最长子字符串的长度（一）
 */
public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == 'o') {
                    count++;
                }
            }
            if (count % 2 == 0) {
                System.out.println(s.length());
            } else {
                System.out.println(s.length() - 1);
            }
        }
    }
}
