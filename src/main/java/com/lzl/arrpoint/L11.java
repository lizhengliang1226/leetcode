package com.lzl.arrpoint;

/**
 * 盛最多水的容器
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/07
 */
public class L11 {

    public static void main(String[] args) {
        new L11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器。
     * 使用双指针
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxV = Integer.MIN_VALUE;
        while (left < right) {
            maxV = Math.max(Math.min(height[left], height[right]) * (right - left), maxV);
            if (height[left] < height[right]) {
                int temp = height[left];
                while (left < right && height[left] <= temp)
                    left++;
            } else {
                int temp = height[right];
                while (left < right && height[right] <= temp)
                    right--;
            }
        }
        return maxV;
    }
}