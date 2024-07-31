package com.lzl.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 小朋友来自多少小区
 */
public class T29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : s) {
            int d = i + 1;
            countMap.put(d, countMap.getOrDefault(d, 0) + 1);
        }
        int red = 0;
        for (Map.Entry<Integer, Integer> en : countMap.entrySet()) {
            Integer num = en.getKey();
            Integer count = en.getValue();
            int b = (int) Math.ceil((double) count / num);
            red += b;
        }
        System.out.println(red);

    }
}
