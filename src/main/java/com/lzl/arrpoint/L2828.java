package com.lzl.arrpoint;

import java.util.ArrayList;
import java.util.List;

/**
 * 2828. 判别首字母缩略词
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串数组 words 和一个字符串 s ，请你判断 s 是不是 words 的 首字母缩略词 。
 *
 * 如果可以按顺序串联 words 中每个字符串的第一个字符形成字符串 s ，则认为 s 是 words 的首字母缩略词。例如，"ab" 可以由 ["apple", "banana"] 形成，但是无法从 ["bear", "aardvark"] 形成。
 *
 * 如果 s 是 words 的首字母缩略词，返回 true ；否则，返回 false 。
 * @author lzl
 * @version 1.0
 * @since 2023/12/20
 */
public class L2828 {
    public static void main(String[] args) {
        List<String> words=new ArrayList<>();
        words.add("alice");
        words.add("bob");
        words.add("charlie");
        System.out.println(new L2828().isAcronym(words, "abc"));
    }
    public boolean isAcronym(List<String> words, String s) {
        if(words.size()!=s.length())return false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!= words.get(i).charAt(0))return false;
        }
        return true;
    }
}