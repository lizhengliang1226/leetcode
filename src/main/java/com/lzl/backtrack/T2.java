package com.lzl.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * @author LZL
 * @version v1.0
 * @date 2023/8/6-20:13
 */
public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
//        while (true) {
        int n = in.nextInt();
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(in.nextInt());
            n--;
        }
        Long max = 0L;
        for (int i = 0; i < nums.size() - 1; i++) {
            Long sum = splitByIndex(nums, i);
            max = sum > max ? sum : max;
        }
        if (nums.size() == 1) {
            System.out.println(nums.get(0));
        } else {
            System.out.println(max);
        }
//        }
    }

    private static Long splitByIndex(List<Integer> nums, int i) {
        //111111111111111111111111111111;
        //1000000000000000000000000000;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i1 = 0; i1 < nums.size(); i1++) {
            if (i1 <= i) {
                left.add(nums.get(i1));
            } else {
                right.add(nums.get(i1));
            }
            if (i1 + 1 == nums.size()) {
                Long sum = left.stream().mapToLong(value -> Long.valueOf(value)).sum();
                Long sum1 = right.stream().mapToLong(value -> Long.valueOf(value)).sum();
                left.clear();
                right.clear();
                long l = sum - sum1;
                return Math.abs(l);
            }
        }
        return 0L;
    }
}
