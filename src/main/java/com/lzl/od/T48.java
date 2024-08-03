package com.lzl.od;

import java.util.Scanner;
import java.util.Stack;

/**
 * a
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T48 {
    public static void main(String[] args) {
        // 123#4$5#67$78
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = infixToPostfix(s);
        System.out.println(postfixEval(s1));
    }

    public static int getpre(char c) {
        switch (c) {
            case '$':
                return 1;
            case '#':
                return 2;
            default:
                return 0;
        }
    }

    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = infix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '#' || c == '$') {
                sb.append(' ');
                while (!stack.isEmpty() && getpre(stack.peek()) >= getpre(c)) {
                    sb.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(' ').append(stack.pop());
        }
        return sb.toString();
    }

    public static int postfixEval(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] split = postfix.split(" ");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            char c = s.charAt(0);
            if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(s));
            } else if (c == '$' || c == '#') {
                int right = stack.pop();
                Integer pop = stack.pop();
                int v = calculate(pop, right, c);
                stack.push(v);
            }
        }
        return stack.pop();
    }

    private static int calculate(Integer y, int x, char c) {
        if (c == '#') {
            return 4 * y + 3 * x + 2;
        } else if (c == '$') {
            return 2 * y + x + 3;
        }
        return 0;
    }
}
