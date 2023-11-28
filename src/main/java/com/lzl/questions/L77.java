package com.lzl.questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author LZL
 * @version v1.0
 * @date 2023/8/5-18:24
 */
public class L77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();
        dfs(n,k,res,path,1,0);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        new L77().combine(4,2);
    }

    private void dfs(int n, int dep, List<List<Integer>> res, Deque<Integer> path, int i,int cutdep) {
        if(dep==cutdep){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j <=n; j++) {
            path.addLast(j);
            dfs(n,dep,res,path,j+1,cutdep+1);
            path.removeLast();
        }
    }
}