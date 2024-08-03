package com.lzl.od;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 求幸存数之和
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("]");
        List<Integer> array = Arrays.stream(split[0].trim().substring(1).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        String[] split1 = split[1].trim().substring(1).split(",");
        int jump = Integer.parseInt(split1[0]);
        int size = Integer.parseInt(split1[1]);
        if (size >= array.size()) {
            int sum = array.stream().mapToInt(Integer::intValue).sum();
            System.out.println(sum);
            return;
        }
        int c = 0;
        while (array.size() > size) {
            int nexi = (c + jump) % array.size();
            array.remove((nexi + 1) % array.size());
            c = nexi % array.size();
        }
        int sum = array.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}

