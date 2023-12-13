package com.lzl.datastruct;

/**
 * 差分数组
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/13
 */
public class DiffArr {
    public static void main(String[] args) {
        int[] a=new int[]{1,3,5,9,6,7};
        int[] dif=new int[a.length];
        // 1 2 2 4 -3 1
        // 构造差分数组
        dif[0]=a[0];
        for (int i = 1; i < a.length; i++) {
            dif[i]=a[i]-a[i-1];
        }
        // 通过差分数组还原原数组
        int[] res = new int[a.length];
        res[0] = dif[0];
        for (int i = 1; i < dif.length; i++) {
            res[i] = res[i - 1] + dif[i];
        }
    }
}