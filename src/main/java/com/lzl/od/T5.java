package com.lzl.od;

import java.util.Scanner;
import java.util.Stack;

/**
 * 密码输入检测
 */
public class T5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        int[] f = new int[5];
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            char c = pop;
            if (c >= 'A' && c <= 'Z') {
                f[0] = 1;
            } else if (c >= 'a' && c <= 'z') {
                f[1] = 1;
            } else if (c >= '0' && c <= '9') {
                f[2] = 1;
            } else {
                f[3] = 1;
            }
            sb.append(pop.toString());
        }
        String s1 = sb.reverse().toString();
        if (s1.length() >= 8) {
            f[4] = 1;
        }
        boolean flag = true;
        for (int i = 0; i < f.length; i++) {
            if (f[i] == 0) {
                flag = false;
                break;
            }
        }
        System.out.printf("%s,%s", s1, flag);

    }
}
