package com.lzl.questions;

/**
 * 43. 字符串相乘
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * @author lzl
 * @version 1.0
 * @since 2023/12/03
 */
public class L43 {
    public String multiply(String num1, String num2) {
        char[] mul1 = num1.toCharArray();
        char[] mul2 = num2.toCharArray();
        int[] mulVal=new int[10000];
        // 1 2
        // 1 8
        //  9 6
        // 1  2
        //216
        int m1=mul1.length-1;
        int m2=mul2.length-1;
        while(m1>=0&&m2>=0){
            int mv1=mul1[m1]-'0';
            int mv2=mul2[m2]-'0';
            int mulVal1=mv1*mv2;
//            mulVal[10000-]
        }
        return null;
    }
}
