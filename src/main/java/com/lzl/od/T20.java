package com.lzl.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 虚拟游戏理财
 */
public class T20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入数据
        int m = scanner.nextInt();
        int totalInvestment = scanner.nextInt();
        int maxRisk = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        int[] returns = new int[m];
        int[] risks = new int[m];
        int[] maxInvestments = new int[m];

        for (int i = 0; i < m; i++) {
            returns[i] = scanner.nextInt();
        }
        scanner.nextLine(); // 消耗换行符

        for (int i = 0; i < m; i++) {
            risks[i] = scanner.nextInt();
        }
        scanner.nextLine(); // 消耗换行符

        for (int i = 0; i < m; i++) {
            maxInvestments[i] = scanner.nextInt();
        }

        scanner.close();

        // 用于保存最大回报和投资额的组合
        int bestReturn = 0;
        int[] bestInvestment = new int[m];

        // 单一产品的投资情况
        for (int i = 0; i < m; i++) {
            int invest = Math.min(totalInvestment, maxInvestments[i]);
            int risk = risks[i];
            int ret = invest * returns[i];

            if (risk <= maxRisk && ret > bestReturn) {
                bestReturn = ret;
                Arrays.fill(bestInvestment, 0);
                bestInvestment[i] = invest;
            }
        }

        // 两个产品的投资情况
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                // 遍历每个投资额组合
                for (int invest1 = 1; invest1 <= maxInvestments[i]; invest1++) {
                    for (int invest2 = 1; invest2 <= maxInvestments[j]; invest2++) {
                        if (invest1 + invest2 <= totalInvestment) {
                            int totalRisk = risks[i] + risks[j];
                            if (totalRisk <= maxRisk) {
                                int totalReturn = invest1 * returns[i] + invest2 * returns[j];
                                if (totalReturn > bestReturn) {
                                    bestReturn = totalReturn;
                                    Arrays.fill(bestInvestment, 0);
                                    bestInvestment[i] = invest1;
                                    bestInvestment[j] = invest2;
                                }
                            }
                        }
                    }
                }
            }
        }

        // 输出结果
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (i > 0) result.append(" ");
            result.append(bestInvestment[i]);
        }
        System.out.println(result.toString());
    }
}
