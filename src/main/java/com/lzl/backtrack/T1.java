package com.lzl.backtrack;

import cn.hutool.core.text.StrBuilder;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.*;

/**
 * @author LZL
 * @version v1.0
 * @date 2023/8/6-19:56
 */
public class T1 {
    public static void main(String[] args) {
        Stack<String> a = new Stack<>();
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        if (s.length() == 1) {
            System.out.println(s.charAt(0) + "0");
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                System.out.println(s.charAt(0) + "2");
            } else {
                System.out.println(s.charAt(0) + "0" + s.charAt(1) + "0");
            }
        } else {
            char cur = '1';
            //caabbcc
            String lowerCase = s.toLowerCase();
            for (int i = 0; i < lowerCase.toCharArray().length; i++) {
                char c = lowerCase.charAt(i);
                if (!a.isEmpty()) {
                    if (c == cur) {
                        int i1 = Integer.valueOf(a.pop()) + 1;
                        a.push(String.valueOf(i1));
                        cur = c;
                    } else {
                        a.push(String.valueOf(c));
                        a.push("1");
                        cur = c;
                    }
                } else {
                    a.push(String.valueOf(c));
                    a.push("1");
                    cur = c;
                    continue;
                }
            }
            Deque<String> a1 = new ArrayDeque<>();
            while (!a.isEmpty()) {
                a1.addFirst(a.pop());
            }
            List<String> yt = new ArrayList<>(a1);
            int size = yt.size();
            int p = 0;
            StringBuilder tt = new StringBuilder();
            List<String> l1 = new ArrayList<>();
            while (p < size) {
                String first = yt.get(p);
                String first1 = yt.get(p + 1);
                if (first1.equals("1")) {
                    int uu = getNum(first, p + 2, size, yt);
                    if (uu != 0) {
                        l1.add(first);
                        l1.add(String.valueOf(uu));
                    } else {
                        l1.add(first);
                        l1.add(String.valueOf(0));
                    }
                } else {
                    l1.add(first);
                    l1.add(first1);
                }
                p += 2;
            }
            while (!l1.isEmpty()) {
                if(tt.toString().equals("")){
                }else{
                    char c = tt.charAt(0);
                    int c1 = tt.charAt(1);
                }
            }
            System.out.println(tt);
        }
    }

    private static int getNum(String first, int i, int size, List<String> yt) {
        int sum = 0;
        for (int i1 = i; i1 < yt.size(); i1 += 2) {
            if (yt.get(i1).equals(first)) {
                String s = yt.get(i1 + 1);
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }

    private static int getNum(String first, Deque<String> a1) {
        return 0;
    }
}
