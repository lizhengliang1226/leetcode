package com.lzl.questions;

import java.util.*;

/**
 * 30. 串联所有单词的子串
 * 困难
 * 相关标签
 * 相关企业
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * <p>
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。
 * "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/30
 */
public class L30 {
    public static void main(String[] args) {
        System.out.println(new L30().findSubstring("foobarbarfoo", new String[]{"foo", "bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Set<Integer> res = new HashSet<>();
        if (s.length() == 0) {
            return new ArrayList<>(res);
        }
        if (words.length == 0) {
            return new ArrayList<>(res);
        }
        if (words.length == 1 && s.length() == 1) {
            if (s.equals(words[0])) {
                List<Integer> r = new ArrayList<>();
                r.add(0);
                return r;
            }
            return new ArrayList<>(res);
        }
        int n = words.length;
        boolean[] used = new boolean[n];
        StringBuilder path = new StringBuilder();
        dfs(words, used, path, n, 0, s, res);
        return new ArrayList<>(res);
    }

    private void dfs(String[] words, boolean[] used, StringBuilder path, int n, int dep, String s, Set<Integer> res) {
        if (dep == n) {
            String string = path.toString();
            System.out.println(string);
            int i = s.indexOf(string);
            if (i != -1) {
                res.addAll(findSubstring1(s, string));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                int l = words[i].length();
                path.append(words[i]);
                dfs(words, used, path, n, dep + 1, s, res);
                used[i] = false;
                path.delete(path.length() - l, path.length());
            }
        }
    }

    public List<Integer> findSubstring1(String s, String words) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        int n = words.length();
        StringBuilder sb = new StringBuilder();
        while (right < s.length()) {
            sb.append(s.charAt(right));
            while (sb.length() == n) {
                if (sb.toString().contains(words)) {
                    res.add(left);
                }
                sb.deleteCharAt(0);
                left++;
            }
            right++;
        }

        return res;


    }

    /*
           List<Integer> res = new ArrayList<>();
           int left = 0, right = 0;
           int windowSize = 0;
           Map<String, Integer> need = new HashMap<>();
           for (String value : words) {
               windowSize += value.length();
               need.put(value, need.getOrDefault(value, 0) + 1);
           }
           StringBuilder sb = new StringBuilder();
           while (right < s.length()) {
               char c = s.charAt(right);
               sb.append(c);
               while (right - left + 1 == windowSize) {
                   String string = sb.toString();
                   int f = 0;
                   label:
                   for (Map.Entry<String, Integer> e : need.entrySet()) {
                       int fromIndex = 0;
                       for (int i = 0; i < e.getValue(); i++) {
                           int i1 = string.indexOf(e.getKey(), fromIndex);
                           if (i1 == -1) {
                               f = 1;
                               break label;
                           } else {
                               fromIndex = i1 + e.getKey().length();
                           }
                           // sb.delete()
                       }
                   }
                   if (f == 0) {
                       res.add(left);
                   }
                   sb.deleteCharAt(0);
                   left++;
               }
               right++;
           }
           return res;

         * */

}