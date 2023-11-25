package com.lzl;

/**
 * @author LZL
 * @version 1.0
 * @since 2023/10/28
 */
public class 凑零钱 {
    public static void main(String[] args) {
        new 凑零钱().coinChange(new int[]{1,2,5},11);
    }
    int coinChange(int[] coins, int amount){
        return dp(coins,amount);
    }

    private int dp(int[] coins, int amount) {
        System.out.println("计算"+amount);
        if(amount==0)return 0;
        if(amount<0)return -1;
        int res=Integer.MAX_VALUE;
        for (int coin : coins) {
            int subPro=dp(coins,amount-coin);
            System.out.println("子问题解"+subPro);
            if(subPro==-1)continue;
            res=Math.min(res,subPro+1);
            System.out.println("计算"+amount+"的res="+res);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
