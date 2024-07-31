package com.lzl.od;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提取字符串中最长的数学表达式并计算
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile("[-+]?\\d+(?:[-+*]\\d+)+");
        String longStr = "";
        Matcher matcher = p.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            if (group.length() > longStr.length()) {
                longStr = group;
            }
        }
        System.out.println(longStr);
        if(longStr.startsWith("+")||longStr.startsWith("-")){
            longStr = "0"+longStr;
        }
        String s1 = infixToPostfix(longStr);
        System.out.println(evaluatePostfix(s1));

    }

    public static int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    public static String infixToPostfix(String s) {
        // 结果集
        StringBuilder sb = new StringBuilder();
        // 栈
        Stack<Character> stack = new Stack<>();
        // 遍历字符串
        for (char c : s.toCharArray()) {
            // 数字直接往里压，且不要带' '
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '(') {
                // 左括号直接压
                stack.push(c);
            } else if (c == ')') {
                // 遇到右括号，不断的从栈顶去找，直到找到左括号
                while (!stack.isEmpty() && stack.peek() != '(') {
                    // 存入栈顶元素，注意带' '
                    sb.append(' ').append(stack.pop());
                }
                // 最后要把多余的左括号弹出来
                stack.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // 遇到操作符，则先压个' '
                sb.append(' ');
                // 找栈顶比自己优先级高的，比我高或者等于我的都要出栈，进入结果集
                // 比如乘法，先进表达式，之后就会先乘后加
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    // 优先级大于等于自己的，出栈进结果集
                    sb.append(stack.pop()).append(' ');
                }
                // 最后把自己压入栈
                stack.push(c);
            }
        }
        // 栈不为空，还有操作。则全部弹出，给到结果集
        while (!stack.isEmpty()) {
            sb.append(' ').append(stack.pop());
        }
        // 返回逆波兰表达式
        return sb.toString();
    }
    public static int evaluatePostfix(String s) {
        // 栈来计算逆波兰
        Stack<Integer> stack = new Stack<>();
        // 按之前的' '分割，得到每个token
        for (String token : s.split(" ")) {
            // 可能有些地方有问题，分割得到了空 ，就跳过
            if(token.isEmpty())continue;;
            // 取第一个字符来看是不是数字，数字则直接入栈准备操作
            if(Character.isDigit(token.charAt(0))){
                stack.push(Integer.parseInt(token));
            }else {
                // 不是数组，那就是操作符。弹出两个操作数
                int a = stack.pop();
                int b = stack.pop();
                // 根据规则，加减乘除
                switch (token.charAt(0)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':// 注意，减是栈靠内的来减外面的
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                    default:
                        break;
                }
            }
        }
        // 操作完成后，返回栈顶元素极为结果
        return stack.pop();
    }
}