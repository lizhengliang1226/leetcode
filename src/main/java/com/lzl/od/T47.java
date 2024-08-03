package com.lzl.od;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 密码解密
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile("\\d{2}\\*|\\d");
        Matcher matcher = p.matcher(s);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String group = matcher.group();
            String a = cth(group);
            sb.append(a);
        }
        System.out.println(sb.toString());
    }

    private static String cth(String group) {
        switch (group) {
            case "1":
                return "a";
            case "2":
                return "b";
            case "3":
                return "c";
            case "4":
                return "d";
            case "5":
                return "e";
            case "6":
                return "f";
            case "7":
                return "g";
            case "8":
                return "h";
            case "9":
                return "i";
            case "10*":
                return "j";
            case "11*":
                return "k";
            case "12*":
                return "l";
            case "13*":
                return "m";
            case "14*":
                return "n";
            case "15*":
                return "o";
            case "16*":
                return "p";
            case "17*":
                return "q";
            case "18*":
                return "r";
            case "19*":
                return "s";
            case "20*":
                return "t";
            case "21*":
                return "u";
            case "22*":
                return "v";
            case "23*":
                return "w";
            case "24*":
                return "x";
            case "25*":
                return "y";
            case "26*":
                return "z";
            default:
                return "";
        }
    }

}
