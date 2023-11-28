package com.lzl.questions;

import java.util.*;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 * @author LZL
 * @version v1.0
 * @date 2023/7/8-18:18
 */
public class L46  {
    public List<List<Integer>> permute(int[] nums) {
        int l=nums.length;
        boolean[] used=new boolean[l];
        List<List<Integer>> res=new ArrayList<>();
        ArrayDeque<Integer> path=new ArrayDeque<>();
        dfs(nums,0,l,used,res,path);
        return res;
    }

    private void dfs(int[] nums, int dep, int l, boolean[] used, List<List<Integer>> res, ArrayDeque<Integer> path) {
        if(dep==l){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < l; i++) {
            if(!used[i]){
                path.addLast(nums[i]);
                used[i]=true;
                dfs(nums,dep+1,l,used,res,path);
                used[i]=false;
                path.removeLast();
            }
        }
    }


}