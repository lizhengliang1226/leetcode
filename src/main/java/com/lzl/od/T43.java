package com.lzl.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 英文输入法
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/02
 */
public class T43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String prefix = sc.nextLine();
        Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
        Matcher matcher = p.matcher(str);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            String word = matcher.group();
            if (word.startsWith(prefix)) {
                words.add(word);
            }
        }
        words.sort(String::compareTo);
        System.out.println(String.join(" ", words));
    }
}