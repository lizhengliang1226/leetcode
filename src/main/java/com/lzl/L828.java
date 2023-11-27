package com.lzl;

import java.rmi.Remote;
import java.util.*;

/**
 * 828. 统计子串中的唯一字符
 * 困难
 * 相关标签
 * 相关企业
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 * <p>
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 * <p>
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
 * <p>
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 */
public class L828 {
    public static void main(String[] args) {
        new L828().uniqueLetterString("abcd");
    }

    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<>();
        // 得到每个字符的坐标
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);


        }
        // 遍历公式使用坐标计算总的字符数
        int res = 0;
        for (Map.Entry<Character, List<Integer>> e : index.entrySet()) {
            Character c = e.getKey();
            List<Integer> arr = e.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }

        return res;
    }

    /**
     * 返回一个字符串中的唯一字符数
     *
     * @param s
     * @return
     */
    public int countUniqueChars(String s) {
        return 0;
    }

    public void dfs(char[] chars, int start, Deque<Character> path) {
//        if(start==chars.length){
//            return;
//        }
//        // abc
//        // a b   c
//        // ab bc abc
//        for (int i = start; i < chars.length; i++) {
//            char aChar = chars[i];
//            path.addLast(aChar);
//            System.out.println(path);
//            dfs(chars,i+1,path);
//            path.removeLast();
//        }
        List<String> dp = new ArrayList<>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        for (Map.Entry e : objectObjectHashMap.entrySet()) {

        }
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            String e = String.valueOf(aChar);
            if (!dp.contains(e)) {
                dp.add(e);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            String baseStr = dp.get(i);
            for (int j = i + 1; j < chars.length; j++) {

            }
        }
    }
}
