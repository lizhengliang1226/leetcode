package com.lzl;

import cn.hutool.core.map.MapUtil;
import sun.applet.Main;

import java.util.*;

/**
 * N皇后问题
 *
 * @author LZL
 * @version v1.0
 * @date 2022/8/8-13:12
 */
public class SolveQueen {
    public static void main(String[] args) {
        final List<List<String>> lists = new SolveQueen().solveNQueens(8);
        for (List<String> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        int[] col = new int[n];
        Set<Integer> dir1=new HashSet<>();
        Set<Integer> dir2=new HashSet<>();
        dfs(res, queens,n,0,col,dir1,dir2);
        return res;
    }

    private void dfs(List<List<String>> res, int[] queens, int n, int row, int[] col, Set<Integer> dir1, Set<Integer> dir2) {
        if(row==n){
            List<String> board=generateRes(queens,n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            // i表示皇后的位置
            if(col[i]==1){
                continue;
            }
            int dir11=row-i;
            if(dir1.contains(dir11)){
                continue;
            }
            int dir22=row+i;
            if(dir2.contains(dir22)){
                continue;
            }
            queens[row]=i;
            col[i]=1;
            dir1.add(dir11);
            dir2.add(dir22);
            dfs(res, queens,n,row+1,col,dir1,dir2);
            dir2.remove(dir22);
            dir1.remove(dir11);
            col[i]=0;
            queens[row]=-1;
        }
    }

    private List<String> generateRes(int[] queens, int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] b=new char[n];
            Arrays.fill(b,'.');
            b[queens[i]]='Q';
            res.add(new String(b));
        }
        return res;
    }
}