class Solution {
    public static void solve(int n,int open,int close,String curr,List<String> ans){
        if(open==n && close==n){
            ans.add(curr);
            return;
        }
        if(open<n){
            solve(n,open+1,close,curr+"(",ans);
        }
        if(close<open){
            solve(n,open,close+1,curr+")",ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        solve(n,0,0,"",ans);
        return ans;
    }
}