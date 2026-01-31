class Solution {
    public static int solve(int idx,int[] prices,int buy,int cap,int[][][] dp){
        if(cap==0) return 0;
        if(idx==prices.length) return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        int profit=0;
        if(buy==1){
            profit+=Math.max(-prices[idx]+solve(idx+1,prices,0,cap,dp),solve(idx+1,prices,1,cap,dp));
        }else{
            profit+=Math.max(prices[idx]+solve(idx+1,prices,1,cap-1,dp),solve(idx+1,prices,0,cap,dp));
        }
        return dp[idx][buy][cap]=profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,prices,1,k,dp);
    }
}