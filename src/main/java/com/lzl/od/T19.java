package com.lzl.od;

import java.util.Scanner;

/**
 * 分割均衡字符串
 */
public class T19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.trim().toCharArray();
        int countX = 0;
        int countY = 0;
        int blance = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'X') {
                countX++;

            } else if (aChar == 'Y') {
                countY++;
            }
            if (countX == countY) {
                blance++;
                countX = 0;
                countY = 0;
            }
        }
        System.out.println(blance);
    }


}
