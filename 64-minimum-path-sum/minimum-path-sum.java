class Solution {
    public static int solve(int i,int j,int[][] grid,int[][] dp){
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int up=solve(i-1,j,grid,dp);
        int left=solve(i,j-1,grid,dp);
        return dp[i][j]=grid[i][j]+Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       int[][] dp=new int[n][m];
       for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
       } 
       return solve(n-1,m-1,grid,dp);
    }
}