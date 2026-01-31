class Solution {
    public static int solve(int idx,int[] coins,int amount,int[][] dp){
        if(amount==0) return 0;
        if(idx==0){
            return amount%coins[idx]==0 ? amount/coins[idx] : Integer.MAX_VALUE;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int pick=Integer.MAX_VALUE;
        if(coins[idx]<=amount){
            int res=solve(idx,coins,amount-coins[idx],dp);
            if(res!=Integer.MAX_VALUE){
                pick=1+res;
            }
        }
        int nopick=solve(idx-1,coins,amount,dp);
        return dp[idx][amount]=Math.min(pick,nopick);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(n-1,coins,amount,dp);
        return (ans==Integer.MAX_VALUE) ? -1 : ans;
    }
}