package com.lzl.questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 752. 打开转盘锁
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 */
public class L752 {
    public static void main(String[] args) {
        System.out.println(new L752().openLock(new String[]{"1234,8566,4123,1211"}, "1235"));
    }

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        Set<String> dead = Arrays.stream(deadends).collect(Collectors.toSet());
        if (dead.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int count = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String poll = q.poll();
                if (poll.equals(target)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    String s1 = plusOne(poll, j);
                    String s2 = subOne(poll, j);
                    if (!dead.contains(s1)) {
                        if (!visited.contains(s1)) {
                            q.offer(s1);
                            visited.add(s1);
                        }
                    }
                    if (!dead.contains(s2)) {
                        if (!visited.contains(s2)) {
                            q.offer(s2);
                            visited.add(s2);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public String plusOne(String s, int j) {
        char[] charArray = s.toCharArray();
        if (charArray[j] == '9') {
            charArray[j] = '0';
        } else {
            charArray[j]++;
        }
        return new String(charArray);
    }

    public String subOne(String s, int j) {
        char[] charArray = s.toCharArray();
        if (charArray[j] == '0') {
            charArray[j] = '9';
        } else {
            charArray[j]--;
        }
        return new String(charArray);
    }
}