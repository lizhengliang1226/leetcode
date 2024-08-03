package com.lzl.od;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 找朋友
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int tall = sc.nextInt();
            a[i] = tall;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                Integer poll = stack.pop();
                res[poll] = i;
            }
            stack.push(i);
        }
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
