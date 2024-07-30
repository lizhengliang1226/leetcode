package com.lzl.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 查找接口成功率最优时间段
 */
public class T18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取 minAverageLost
        int minAverageLost = scanner.nextInt();
        scanner.nextLine();  // 消耗换行符

        // 读取失败率数组
        String[] rateStrings = scanner.nextLine().split(" ");
        int[] failRates = new int[rateStrings.length];
        for (int i = 0; i < rateStrings.length; i++) {
            failRates[i] = Integer.parseInt(rateStrings[i]);
        }

        // 初始化变量
        int maxLength = 0;
        List<String> result = new ArrayList<>();

        int sum = 0;
        int left = 0;

        // 遍历数组
        for (int right = 0; right < failRates.length; right++) {
            // 取出窗口值
            sum += failRates[right];

            // 计算当前时间段的平均失败率
            while (left <= right && (double) sum / (right - left + 1) > minAverageLost) {
                sum -= failRates[left];
                left++;
            }

            // 如果找到新的最长时间段
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                result.clear();
                result.add(left + "-" + right);
            } else if (right - left + 1 == maxLength) {
                result.add(left + "-" + right);
            }
        }

        // 打印结果
        if (result.isEmpty()) {
            System.out.println("NULL");
        } else {
            System.out.println(String.join(" ", result));
        }

        scanner.close();
    }
}
