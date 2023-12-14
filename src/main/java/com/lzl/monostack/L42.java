package com.lzl.monostack;

/**
 * 42. 接雨水
 * 困难
 * 相关标签
 * 相关企业
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/08
 */
public class L42 {
    public static void main(String[] args) {
        System.out.println(new L42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        int[] s = new int[height.length];
        int lens = 0;
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            while (lens > 0 && height[s[lens - 1]] < height[i]) {
                int popIndex = s[lens - 1];
                int pop = height[popIndex];
                lens--;
                if (lens == 0) {
                    break;
                }
                total += (i - s[lens - 1] - 1) * (Math.min(height[s[lens - 1]], height[i]) - pop);
            }
            s[lens++] = i;
        }
        return total;
    }
}