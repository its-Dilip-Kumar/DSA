class Solution {
    public static int solve(int idx,int[] nums,int[] dp){
        if(idx==0) return nums[idx];
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int take=nums[idx]+solve(idx-2,nums,dp);
        int notake=solve(idx-1,nums,dp);
        return dp[idx]=Math.max(take,notake);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
        for(int i=0;i<n-1;i++){
            temp1[i]=nums[i];
        }   
        for(int i=1;i<n;i++){
            temp2[i-1]=nums[i];
        }
        int[] dp1=new int[n-1];
        int[] dp2=new int[n-1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int ans1=solve(temp1.length-1,temp1,dp1);
        int ans2=solve(temp2.length-1,temp2,dp2);
        return Math.max(ans1,ans2);
    }
}