package com.lzl.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 机场航班调度程序
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] i = s.trim().split(",");
        Arrays.sort(i, (o1, o2) -> {
            int l1 = o1.length();
            int l2 = o2.length();
            int num1 = Integer.parseInt(o1.substring(l1 - 4, l1));
            String hb1 = o1.substring(0, 2);
            int num2 = Integer.parseInt(o2.substring(l2 - 4, l2));
            String hb2 = o2.substring(0, 2);
            int cm = num1 - num2;
            int i1 = hb1.compareTo(hb2);
            if (i1 == 0) {
                return cm;
            } else {
                return i1;
            }
        });
        System.out.println(String.join(",", i));
    }
}