package com.lzl.monostack;

import java.util.*;

/**
 * 901. 股票价格跨度
 * 中等
 * 相关标签
 * 相关企业
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/13
 */
public class L901 {
    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        s.next(100);
        s.next(80);
        s.next(60);
        s.next(70);
        s.next(60);
        s.next(75);
        s.next(85);
    }
}

class StockSpanner {
    List<Integer> prices = new ArrayList<>();

    public StockSpanner() {

    }

    Deque<int[]> stack = new LinkedList<>();
    int lens = 0;

    /**
     * 正向单调栈，假想这个next就是在for循环，只不过是被外部调用的
     *
     * @param price
     * @return
     */
    public int next(int price) {
        lens++;
        // 左左大小大
        while (!stack.isEmpty() && stack.peek()[0] <= price) stack.pop();
        int t = !stack.isEmpty() ? lens - stack.peek()[1] - 1 : lens;
        stack.push(new int[]{price, lens - 1});
        return t;
    }

    /**
     * 垃圾做法，巨慢
     *
     * @param price
     * @return
     */
    public int next1(int price) {
        prices.add(price);
        for (int i = prices.size() - 1; i >= 0; i--) {
            if (prices.get(i) > price) {
                return prices.size() - i - 1;
            }
        }
        return prices.size();
    }
}