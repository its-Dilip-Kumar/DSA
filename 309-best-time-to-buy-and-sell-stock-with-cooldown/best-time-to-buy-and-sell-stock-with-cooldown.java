class Solution {
    public static int solve(int idx,int[] prices,int buy,int[][] dp){
        if(idx>=prices.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==1){
            profit+=Math.max(-prices[idx]+solve(idx+1,prices,0,dp),solve(idx+1,prices,1,dp));
        }else{
            profit+=Math.max(prices[idx]+solve(idx+2,prices,1,dp),solve(idx+1,prices,0,dp));
        }
        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,prices,1,dp);  
    }
}