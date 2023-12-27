package com.lzl.questions;

/**
 * 1954. 收集足够苹果的最小花园周长
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个用无限二维网格表示的花园，每一个 整数坐标处都有一棵苹果树。整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果。
 * <p>
 * 你将会买下正中心坐标是 (0, 0) 的一块 正方形土地 ，且每条边都与两条坐标轴之一平行。
 * <p>
 * 给你一个整数 neededApples ，请你返回土地的 最小周长 ，使得 至少 有 neededApples 个苹果在土地 里面或者边缘上。
 * <p>
 * |x| 的值定义为：
 * <p>
 * 如果 x >= 0 ，那么值为 x
 * 如果 x < 0 ，那么值为 -x
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/24
 */
public class L1954 {
    public static void main(String[] args) {
        System.out.println(new L1954().minimumPerimeter(100L));
    }
    public long minimumPerimeter(long neededApples) {
        // 算可以获取的苹果数的公式，n是边长：2n(n+1)(2n+1)
        long left = 1;
        long right = 100000;
        long i = -1;
        while (left < right) {
            i = (left + right) / 2;
            if (2 * i * (i + 1) * (2 * i + 1) < neededApples) {
                left = i + 1;
            } else {
                right = i;
            }
        }
        return 8 * right;
    }
}