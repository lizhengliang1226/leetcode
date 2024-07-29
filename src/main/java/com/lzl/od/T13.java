package com.lzl.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * API集群负载统计   /**
 * *
 * 5
 * /huawei/computing/no/one
 * /huawei/computing
 * /huawei
 * /huawei/cloud/no/one
 * /huawei/wireless/no/one
 * 2 computing
 */
public class T13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int logNum = sc.nextInt();
        // key是第几层，Key是这层的串，value是这个串出现了几次
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < logNum; i++) {
            String log = sc.next();
            String res = log.substring(1);
            String[] split = res.split("/");
            for (int i1 = 0; i1 < split.length; i1++) {
                String s = split[i1];
                map.compute(i1 + 1, (k, v) -> {
                    if (v == null) {
                        Map<String, Integer> m = new HashMap<>();
                        m.put(s, 1);
                        return m;
                    } else {
                        v.compute(s, (k1, v1) -> {
                            if (v1 == null) {
                                return 1;
                            } else {
                                return v1 + 1;
                            }
                        });
                        return v;
                    }
                });
            }
        }
        String s1 = sc.next();
        String s2 = sc.next();
        // 优化下面这段代码结构
        System.out.println(map.getOrDefault(Integer.valueOf(s1), new HashMap<>()).getOrDefault(s2, 0));
    }

}
