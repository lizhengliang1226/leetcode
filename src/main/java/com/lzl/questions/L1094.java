package com.lzl.questions;

/**
 * 1094. 拼车
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/02
 */
public class L1094 {
    public boolean carPooling(int[][] trips, int capacity) {
      int[] map=new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            map[trip[1]]+=trip[0];
            map[trip[2]]-=trip[0];
        }
        int sum=0;
        for (int i = 0; i < map.length; i++) {
            sum+=map[i];
            if(sum>capacity)return false;
        }
        return true;
    }
}

