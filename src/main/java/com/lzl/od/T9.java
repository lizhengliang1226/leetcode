package com.lzl.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 开源项目热榜，开源项目热度榜单
 * 5
 * 5 6 6 1 2
 * camila 13 88 46 26 169
 * grace 64 38 87 23 103
 * lucas 91 79 98 154 79
 * leo 29 27 36 43 178
 * ava 29 27 36 43 178

 4
 8 6 2 8 6
 camila 66 70 46 158 80
 victoria 94 76 86 189 211
 anthony 29 17 83 21 48
 emily 53 97 1 19 218

 */
public class T9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] s = sc.nextLine().split(" ");//5
        List<a> h=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] stu = sc.nextLine().split(" ");
            a a = new a();
            a.name=stu[0];
            a.m1= Integer.parseInt(stu[1]);
            a.m2= Integer.parseInt(stu[2]);
            a.m3= Integer.parseInt(stu[3]);
            a.m4= Integer.parseInt(stu[4]);
            a.m5= Integer.parseInt(stu[5]);
            h.add(a);
        }
        h.sort(new Comparator<a>() {
            @Override
            public int compare(a o1, a o2) {
                int i = o1.m1 * Integer.parseInt(s[0]) + o1.m2 * Integer.parseInt(s[1]) + o1.m3 * Integer.parseInt(s[2]) + o1.m4 * Integer.parseInt(s[3]) + o1.m5 * Integer.parseInt(s[4]);
                int i1 = o2.m1 * Integer.parseInt(s[0]) + o2.m2 * Integer.parseInt(s[1]) + o2.m3 * Integer.parseInt(s[2]) + o2.m4 * Integer.parseInt(s[3]) + o2.m5 * Integer.parseInt(s[4]);
                int i2 = i1 - i;
                String lowerCase = o1.name.toLowerCase();
                String lowerCase1 = o2.name.toLowerCase();
                return i2==0?lowerCase.compareTo(lowerCase1):i2;
            }
        });
        for (com.lzl.od.a a : h) {
            System.out.print(a.name+"\n");
        }
    }
}
class a{
    String name;
    int m1;
    int m2;
    int m3;
    int m4;
    int m5;
}
