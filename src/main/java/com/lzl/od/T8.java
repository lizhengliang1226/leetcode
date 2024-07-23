package com.lzl.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 转盘寿司
 */
public class T8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> kist = new ArrayList<>();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] res = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            int i1 = Integer.parseInt(s1[i]);
            res[i] = i1;
        }
        int[] a = new int[res.length * 2];
        System.arraycopy(res, 0, a, 0, res.length);
        System.arraycopy(res, 0, a, res.length, res.length);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peek()] > a[i]) {
                Integer index = stack.pop();
                a[index] += a[i];
            }
            stack.push(i);
        }
        System.arraycopy(a, 0, res, 0, res.length);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
