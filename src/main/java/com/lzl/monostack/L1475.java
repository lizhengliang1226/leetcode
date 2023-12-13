package com.lzl.monostack;

import java.util.Arrays;

/**
 * 1475. 商品折扣后的最终价格
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * <p>
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，
 * 如果没有满足条件的 j ，你将没有任何折扣。
 * <p>
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/13
 */
public class L1475 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L1475().finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(new L1475().finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(new L1475().finalPrices(new int[]{10, 1, 1, 6})));
    }

    public int[] finalPrices(int[] prices) {
        // Deque<Integer> s = new LinkedList<>();
        // 左左小大小，从左往右遍历push时找到左边第一个比自己小的元素，符号用大于，pop时找到右边第一个比自己小的元素
        int[] s = new int[prices.length];
        int lens = 0;
        for (int i = 0; i < prices.length; i++) {
            while (lens > 0 && prices[s[lens - 1]] >= prices[i]) {
                // 此时pop右边第一个比自己小的元素就是i
                prices[s[lens - 1]] -= prices[i];
                lens--;
            }
            s[lens++] = i;
        }
        return prices;
    }
}