package com.lzl.questions;

/**
 * 67. 二进制求和
 * 简单
 * 相关标签
 * 相关企业
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/07
 */
public class L67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ca = 0;
        // 此处用的||，则当其中一个小于0时依旧进循环
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = 0;
            // 当某个已经加完时，另一个会继续加到结束
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            // 二进制相加时，使用两个二进制位的和x%2即可得到当前位，
            // x/2即可得到此次求和的进位，例如1+1+1,这是二进制相加的最大可能情况，为3，则当前位为3%2=1，进位为3/2=1  1+1=2，2%2=0（当前位），2/2=1（进位）
            sum += ca;
            ca = sum / 2;
            sb.append(sum % 2);
        }
        sb.append(ca == 1 ? "1" : "");
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new L67().addBinary("1111", "1111"));
    }
}