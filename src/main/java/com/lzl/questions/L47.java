package com.lzl.questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LZL
 * @version v1.0
 * @date 2023/8/5-17:02
 */
public class L47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int l=nums.length;
        ArrayDeque<Integer> path=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        boolean[] used=new boolean[l];
        Arrays.sort(nums);
        dfs(0,l,nums,path,res,used);
        return res;
    }

    private void dfs(int dep, int l, int[] nums, ArrayDeque<Integer> path, List<List<Integer>> res, boolean[] used) {
        if(dep==l){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < l; i++) {
            if(used[i])continue;
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(dep+1,l,nums,path,res,used);
            used[i]=false;
            path.removeLast();
        }
    }
}