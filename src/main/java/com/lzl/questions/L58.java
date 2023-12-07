package com.lzl.questions;

/**
 * 58. 最后一个单词的长度
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * @author lzl
 * @version 1.0
 * @since 2023/12/07
 */
public class L58 {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int end=length-1;
        while(end>=0&&s.charAt(end)==' ')end--;
        if(end<0)return 0;
        int start=end;
        while(start>=0&&s.charAt(start)!=' ')start--;
        return end-start;
    }
    public int lengthOfLastWord1(String s) {
        if(s.trim().length()==0)return 0;
        String replaced = s.replaceAll("\\s+", "#");
        String[] split = replaced.split("#");
        return split[split.length-1].length();
    }
}