package com.lzl.od;

import java.util.Scanner;

/**
 * 螺旋矩阵
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = (int) Math.ceil(n * 1.0 / m);
        int[][] matrix = new int[m][k];
        int step = 1;
        int x = 0;
        int y = 0;
        while (step <= n) {
            while (y < k && matrix[x][y] == 0 && step <= n) {
                matrix[x][y++] = step++;
            }
            y -= 1;
            x += 1;
            while (x < m && matrix[x][y] == 0 && step <= n) {
                matrix[x++][y] = step++;
            }
            x -= 1;
            y -= 1;
            while (y >= 0 && matrix[x][y] == 0 && step <= n) {
                matrix[x][y--] = step++;
            }
            y += 1;
            x -= 1;
            while (x >= 0 && matrix[x][y] == 0 && step <= n) {
                matrix[x--][y] = step++;
            }
            x += 1;
            y += 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%s ", matrix[i][j] == 0 ? "*" : matrix[i][j]);
            }
            System.out.print("\n");
        }
    }
}
