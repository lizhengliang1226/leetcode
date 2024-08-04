package com.lzl.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 田忌赛马
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> b = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<List<Integer>> c = getAllPaiLie(a);
        int n = a.size();
        int cou = getCou(c, n, b);
        System.out.println(cou);
    }

    private static int getCou(List<List<Integer>> c, int n, List<Integer> b) {
        int max = Integer.MIN_VALUE;
        int cou = 0;
        for (List<Integer> integers : c) {
            int pc = 0;
            for (int i = 0; i < n; i++) {
                Integer ai = integers.get(i);
                Integer bi = b.get(i);
                if (ai > bi) {
                    pc++;
                } else {
                    break;
                }
            }
            if (pc > max) {
                max = pc;
                cou = 1;
            } else if (pc == max) {
                cou++;
            }
        }
        return cou;
    }

    private static List<List<Integer>> getAllPaiLie(List<Integer> a) {
        if (a.isEmpty()) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        Integer i = a.get(0);
        List<Integer> integers = a.subList(1, a.size());
        List<List<Integer>> res1 = new ArrayList<>();
        List<List<Integer>> res = getAllPaiLie(integers);
        for (List<Integer> list : res) {
            for (int j = 0; j <= list.size(); j++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(j, i);
                res1.add(newList);
            }
        }
        return res1;
    }
}
