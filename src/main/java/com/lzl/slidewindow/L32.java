package com.lzl.slidewindow;

/**
 * 32. 最长有效括号
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @author lzl
 * @version 1.0
 * @since 2023/12/04
 */
public class L32 {
    public int longestValidParentheses(String s) {
        int left=0;
        int right=0;
        StringBuilder win=new StringBuilder();
        int start=0;
        int leftBracketNum=0;
        int rightBracketNum=0;
        int n = s.length();
        int maxLen= -1;
        while(right<n){
            char c = s.charAt(right);
            win.append(c);
            if(c=='('){
                leftBracketNum++;
            }else{
                rightBracketNum++;
            }
            while(leftBracketNum==rightBracketNum){

            }
        }
    }
}