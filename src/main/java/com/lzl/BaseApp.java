package com.lzl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author LZL
 * @version v1.0
 * @date 2023/7/8-18:19
 */
public abstract class BaseApp {
   public static int[] nums=new int[]{1,2,3};
    public static int l = nums.length;
    public static boolean[] used=new boolean[l];
    public static Deque<Integer> tmpRes=new ArrayDeque<>();
    public static List<List<Integer>> res=new ArrayList<>();
    public static void print(List<List<Integer>> res){
        System.out.println(res);
    }
}
