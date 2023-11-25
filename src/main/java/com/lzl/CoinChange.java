package com.lzl;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * @author LZL
 * @version v1.0
 * @date 2022/8/11-9:11
 */
@Slf4j
public class CoinChange {
//    public static void main(String[] args) {
//        System.out.println(new CoinChange().coinChange(new int[]{186,419,83,408}, 6249));
//    }

    public static void main(String[] args) {
        File file = new File("D:\\Keys12");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);
        System.out.println(file.getPath());
        String hello = String.format("%100s", "dddddd");
        System.out.println(hello);
        StringBuilder sb = new StringBuilder();
        sb.append("hello",2,3);
        List<Map<String,String>> list=new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        HashMap<String, String> map3 = new HashMap<>();
        HashMap<String, String> map4 = new HashMap<>();
        map1.put("STK_CODE","730001");
        map2.put("STK_CODE","730006");
        map3.put("STK_CODE","730003");
        map4.put("STK_CODE","7300048");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
//        list.sort((o1, o2) -> {
//            Integer stkCode = Integer.valueOf(String.valueOf(o1.get("STK_CODE")));
//            Integer stkCode1 = Integer.valueOf(String.valueOf(o2.get("STK_CODE")));
//            return stkCode.compareTo(stkCode1);
//        });
//        for (Map map : list) {
//            System.out.println(map.get("STK_CODE"));
//        }
        System.out.println("cjusdihuivchsdiuhvius");
        List<Integer> stkCode = list.stream().map(map -> Integer.valueOf(map.get("STK_CODE"))).sorted().collect(Collectors.toList());
        for (int s : stkCode) {
            System.out.println(s);
        }
        for (int i = 0; i < 10; i++) {

        }
        System.out.println(sb.toString());
    }
    public int coinChange(int[] coins, int amount) {
        // 不断从数组取最大值，每次取出来就剪掉，剩余数大于0，继续取最大值，取出来后剪掉，如果小于0了
        // 重新取次大值，如果还小于0，继续取次大值，直到取完，如果中途有等于0了，结束，
        // 枚举完了都没有等于0的就返回-1
        Arrays.sort(coins);
        List<Integer> res=new ArrayList<Integer>();
        dfs(res,coins, amount, coins.length - 1, 0);
        System.out.println(Arrays.toString(res.toArray()));
        return 0;
    }

    private void dfs(List<Integer> res,int[] coins, int amount, int begin, int cn) {

    }
}