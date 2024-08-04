package com.lzl.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 幼儿园篮球游戏
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> q = new ArrayDeque<>();
        int[] array = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int r = 0;
        int f = 1;
        int[] u = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < u.length; i++) {
            int b = u[i];
            while (f == 1) {
                if (!q.isEmpty() && q.peekFirst() == b) {
                    q.pollFirst();
                    res.append("L");
                    break;
                } else if (!q.isEmpty() && q.peekLast() == b) {
                    q.pollLast();
                    res.append("R");
                    break;
                } else if (r < array.length) {
                    q.addLast(array[r++]);
                } else {
                    f = 0;
                }
            }
            if (f == 0) {
                break;
            }
        }
        String s = res.toString();
        System.out.println(s.length() == u.length ? s : "NO");

    }
}
