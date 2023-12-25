package com.lzl.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1276. 不浪费原料的汉堡制作方案
 * 提示
 * 中等
 * 45
 * 相关企业
 * 圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。
 * <p>
 * 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
 * <p>
 * 巨无霸汉堡：4 片番茄和 1 片奶酪
 * 小皇堡：2 片番茄和 1 片奶酪
 * 请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
 * <p>
 * 如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/25
 */
public class L1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        // 解方程：
        // 4x+2y=tomatoSlices
        // x+y=cheeseSlices
        // x >= 0  y >= 0
        // x=tomatoSlices/2-cheeseSlices>=0
        // y=2cheeseSlices-tomatoSlices/2>=0
        // 由题意可知tomatoSlices还必须是偶数
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices % 2 != 0 || tomatoSlices / 2 - cheeseSlices < 0 || 2 * cheeseSlices - tomatoSlices / 2 < 0) {
            return res;
        }
        res.add((int) (tomatoSlices / 2 - cheeseSlices));
        res.add(2 * cheeseSlices - tomatoSlices / 2);
        return res;
    }
}