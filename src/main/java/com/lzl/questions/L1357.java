package com.lzl.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 1357. 每隔 n 个顾客打折
 * 提示
 * 中等
 * 20
 * 相关企业
 * 超市里正在举行打折活动，每隔 n 个顾客会得到 discount 的折扣。
 * <p>
 * 超市里有一些商品，第 i 种商品为 products[i] 且每件单品的价格为 prices[i] 。
 * <p>
 * 结账系统会统计顾客的数目，每隔 n 个顾客结账时，该顾客的账单都会打折，折扣为 discount （也就是如果原本账单为 x ，那么实际金额会变成 x - (discount * x) / 100 ），然后系统会重新开始计数。
 * <p>
 * 顾客会购买一些商品， product[i] 是顾客购买的第 i 种商品， amount[i] 是对应的购买该种商品的数目。
 * <p>
 * 请你实现 Cashier 类：
 * <p>
 * Cashier(int n, int discount, int[] products, int[] prices) 初始化实例对象，参数分别为打折频率 n ，折扣大小 discount ，超市里的商品列表 products 和它们的价格 prices 。
 * double getBill(int[] product, int[] amount) 返回账单的实际金额（如果有打折，请返回打折后的结果）。返回结果与标准答案误差在 10^-5 以内都视为正确结果。
 */
public class L1357 {
    public static void main(String[] args) {
        int n = 3;
        int discount = 5;
        int[] products = new int[]{4, 8, 5, 6, 9};
        int[] prices = new int[]{1, 2, 3, 4, 5};
        int[] product = new int[]{8, 6};
        int[] amount = new int[]{4, 6};
        Cashier obj = new Cashier(n, discount, products, prices);
        double param_1 = obj.getBill(product, amount);
        System.out.println(param_1);
    }
}

class Cashier {
    private int frequency;
    private int discount;
    // private int[] products;
    // private int[] prices;
    private int num;
    private int[] m;
    private Map<Integer, Integer> map = new HashMap<>(16);

    public Cashier(int n, int discount, int[] products, int[] prices) {
        frequency = n;
        this.discount = discount;
        // this.products = products;
        // this.prices = prices;
        m = new int[300];
        IntStream.range(0, products.length).forEach(i -> {
            m[products[i]] = prices[i];
        });

    }

    public double getBill(int[] product, int[] amount) {
        num++;
        if (num == frequency) {
            // 打折
            num = 0;
            double a = 0.0;
            for (int i = 0; i < product.length; i++) {
                a += getPrice(product[i]) * amount[i];
            }
            double v = a - (discount * a) / 100;
            return v;
        } else {
            // 正常
            double a = 0.0;
            for (int i = 0; i < product.length; i++) {
                a += getPrice(product[i]) * amount[i];
            }
            return a;

        }
    }

    private int getPrice(int productName) {
        return m[productName];
    }
}