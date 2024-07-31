package com.lzl.od;

import java.util.Scanner;

/**
 * 来自异国的客人
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int luck = sc.nextInt();
        int jz = sc.nextInt();
        if (num < 0 || luck < 0 || luck >= jz) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int i = num % jz;
            sb.append(i);
            num = num / jz;
        }
        String string = sb.reverse().toString();
        int count = 0;
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == luck + '0') {
                count++;
            }
        }
        System.out.println(count);

    }
}