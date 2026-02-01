class Solution {
    public static boolean solve(int idx,String s,List<String> wordDict,Boolean[] dp){
        if(idx==s.length()) return true;
        if(dp[idx]!=null) return dp[idx];
        for(String word:wordDict){
            int len=word.length();
            if(idx+len<=s.length() && s.substring(idx,idx+len).equals(word)){
                if(solve(idx+len,s,wordDict,dp)){
                    return dp[idx]=true;
                }
            }
        }
        return dp[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Boolean[] dp=new Boolean[n];
        return solve(0,s,wordDict,dp);
    }
}