package com.lzl.dp;

import java.util.Arrays;

/**
 * 1349. 参加考试的最大学生数
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
 * <p>
 * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的同时参加考试且无法作弊的 最大 学生人数。
 * <p>
 * 学生必须坐在状况良好的座位上。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/26
 */
public class L1349 {
    public static void main(String[] args) {
        System.out.println(new L1349().maxStudents(new char[][]{{'#','.','#','#','.','#'},{'.','#','#','#','#','.'},{'#','.','#','#','.','#'}}));
    }

    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        // 初始化状态数组，保存每行的状态
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') {
                    a[i] |= 1 << j;
                }
            }
        }
        // 初始化备忘录为-1
        int[][] memo = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        // 从最后一排开始，计算最大可坐人数
        return dfs(m - 1, a[m - 1], a, memo);
    }

    private int dfs(int i, int j, int[] a, int[][] memo) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i == 0) {
            if (j == 0) {
                return 0;
            }
            // 到达第一行后，开始算当前行的可坐人数
            // 从最右边的1开始取，每次隔一个1，取完就是可以坐的人数

            // 得到最右边的1
            int lb = j & -j;
            // lb*3就是lb<<1|lb;
            // j&~(lb*3)相当于把最后两位1置为0，表示占了一个位置
            return memo[i][j] = dfs(i, j & ~(lb * 3), a, memo) + 1;
        }
        // 当前行先不坐人
        int res = dfs(i - 1, a[i - 1], a, memo);
        // 开始坐人来改变状态
        for (int s = j; s > 0; s = (s - 1) & j) {// 枚举j的子集
            /*
            此处以s=13为例，枚举的结果如下，其实就是s代表此时已经坐人后形成的状态，s中的1代表已经坐人了，这个操作就可以枚举s为1的位置坐人的所有情况
            1101：初始全坐，剩下的就是把不同位置的1置为0代表坐人了，直到为0，也就是没有位置
            1100
            1001
            1000
            0101
            0100
            0001
            * */
            // 有不相邻的1则可以改变状态，算最大值，因为s要坐人，根据上面枚举的所有值，取那些有不相邻的1的值，就是s可以改变的状态
            if ((s & (s << 1)) == 0) {
                // 存在，那就根据当前的s更新前一排的状态，要求左上，右上不能坐，那么s<<1|s>>1就会得到左上右上不能坐的位置，
                // 然后~得到能坐的，然后与前一排的状态a[i-1]相与，得到前一排受当前排影响后改变的状态
                int t = a[i - 1] & ~(s << 1 | s >> 1);
                res = Math.max(res, dfs(i - 1, t, a, memo) + Integer.bitCount(s));
            }
        }
        return memo[i][j] = res;
    }
}