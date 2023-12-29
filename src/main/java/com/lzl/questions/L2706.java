package com.lzl.questions;

import java.util.Arrays;

/**
 * 2706. 购买两块巧克力
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 prices ，它表示一个商店里若干巧克力的价格。同时给你一个整数 money ，表示你一开始拥有的钱数。
 * <p>
 * 你必须购买 恰好 两块巧克力，而且剩余的钱数必须是 非负数 。同时你想最小化购买两块巧克力的总花费。
 * <p>
 * 请你返回在购买两块巧克力后，最多能剩下多少钱。如果购买任意两块巧克力都超过了你拥有的钱，请你返回 money 。注意剩余钱数必须是非负数。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/29
 */
public class L2706 {
    public static void main(String[] args) {
        System.out.println(new L2706().buyChoco(new int[]{1, 2, 5, 7, 99, 5, 6, 7, 98, 123, 444, 56, 78, 11, 22}, 888));
    }

    public int buyChoco(int[] prices, int money) {
        int n = prices.length;
        Arrays.sort(prices);
        return n >= 2 ? prices[0] + prices[1] > money ? money : money - prices[0] - prices[1] : money;
    }
}