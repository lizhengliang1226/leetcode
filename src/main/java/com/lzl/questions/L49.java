package com.lzl.questions;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/14
 */
public class L49 {
    public static void main(String[] args) {
        System.out.println(new L49().groupAnagrams(new String[]{"ac", "c"}));
    }

    List<List<String>> res = new ArrayList<>();
    List<Map<Character, Integer>> countMap = new ArrayList<>();
    List<String> nullRes = new ArrayList<>();

    /**
     * 排序+hash
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> objects = new ArrayList<>();
                objects.add(str);
                map.put(s, objects);
            }
        }
        return new ArrayList<>(map.values());
    }

    private void addOrCreateGroup(Map<Character, Integer> count, String str) {

    }

    /**
     * 初始写法，慢的要死
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) {
            return res;
        }
        if (strs.length == 1) {
            List<String> a = new ArrayList<>();
            a.add(strs[0]);
            res.add(a);
            return res;
        }
        // 分组的条件是什么？两个单词字母出现的次数一样则分组
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            Map<Character, Integer> count = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            // 得到了每个字母出现的次数
            addOrCreateGroup1(count, str);
        }
        if (!nullRes.isEmpty()) {
            res.add(nullRes);
        }
        return res;
    }

    private void addOrCreateGroup1(Map<Character, Integer> count, String str) {
        if (str.length() == 0) {
            // 空串
            nullRes.add("");
            return;
        }
        boolean f = false;
        for (int i = 0; i < countMap.size(); i++) {
            boolean flag = true;
            Map<Character, Integer> map = countMap.get(i);
            if (count.size() != map.size()) {
                continue;
            }
            for (Map.Entry<Character, Integer> e : count.entrySet()) {
                char c = e.getKey();
                Integer cCount = e.getValue();
                Integer integer = map.get(c);
                if (integer == null) {
                    flag = false;
                    break;
                }
                if (!integer.equals(cCount)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                f = true;
                res.get(i).add(str);
            }
        }
        if (!f) {
            List<String> a = new ArrayList<>();
            a.add(str);
            res.add(a);
            countMap.add(count);
        }
    }
}