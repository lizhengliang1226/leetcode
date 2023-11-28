package com.lzl.questions;

import java.util.List;

/**
 * 2824. 统计和小于目标的下标对数目
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 */
public class L2824 {
    public int countPairs(List<Integer> nums, int target) {
        int size = nums.size();
        int pair=0;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if(nums.get(i)+nums.get(j)<target)pair++;
            }
        }
        return pair;
    }
private int pair=0;
    private void dfs(List<Integer> nums, int curVal, int size, int target,int start) {
       if(curVal==target){
           pair++;
           return ;
       }
        for (int i = start; i < size; i++) {
            if(curVal==Integer.MAX_VALUE){
                curVal=nums.get(i);
            }else{
                curVal+=nums.get(i);
            }
            dfs(nums,curVal,size,target,start+1);

        }
    }
}