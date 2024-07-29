package com.lzl.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 用连续自然数之和来表达整数
 */
public class T12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<String> res = new ArrayList<>();
        res.add(String.format("%d=%d", num, num));
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 1; i < num; i++) {
            sum = i;
            sb.append(i).append("+");
            for (int j = i + 1; j < num; j++) {
                sb.append(j).append("+");
                sum += j;
                if (sum == num) {
                    String s = sb.toString();
                    res.add(num + "=" + s.substring(0, s.length() - 1));
                    sb = new StringBuilder();
                } else if (sum > num) {
                    sb = new StringBuilder();
                    break;
                }
            }
        }
        res.sort(Comparator.comparingInt(String::length));
        System.out.println(String.join("\n", res) + "\n" + "Result:" + res.size());
    }
}
