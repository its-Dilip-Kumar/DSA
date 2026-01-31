class Solution {
    public static boolean solve(int idx,int[] nums,int target,Boolean[][] dp){
        if(target==0) return true;
        if(idx==0){
            return nums[0]==target;
        }
        if(dp[idx][target]!=null) return dp[idx][target];
        boolean pick=false;
        if(nums[idx]<=target){
            pick=solve(idx-1,nums,target-nums[idx],dp);
        }
        boolean notpick=solve(idx-1,nums,target,dp);
        return dp[idx][target]=pick || notpick;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        Boolean[][] dp=new Boolean[n][target+1];
        return solve(n-1,nums,target,dp);
    }
}