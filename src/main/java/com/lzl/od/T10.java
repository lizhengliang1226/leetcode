package com.lzl.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 寻找身高相近的小朋友
 */
public class T10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xmTall = sc.nextInt();
        int num = sc.nextInt();
        int[] arr = new int[num];
        List<Tx> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int tall = sc.nextInt();
            list.add(new Tx(tall, Math.abs(xmTall - tall)));
        }
        list.sort((o1, o2) -> {
            int abs = o1.absWithXm - o2.absWithXm;
            if (abs == 0) {
                return o1.tall - o2.tall;
            } else {
                return abs;
            }
        });
        System.out.println(list.stream().map(xm -> String.valueOf(xm.tall)).collect(Collectors.joining(" ")));
    }
}

class Tx {
    int tall;
    int absWithXm;

    public Tx(int tall, int absWithXm) {
        this.tall = tall;
        this.absWithXm = absWithXm;
    }
}