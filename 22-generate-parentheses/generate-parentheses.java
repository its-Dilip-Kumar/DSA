class Solution {
    public static void solve(int n,List<String> ans,int open,int close,String curr){
        if(open==n && close==n){
            ans.add(curr);
            return;
        }
        if(open<n){
            solve(n,ans,open+1,close,curr+"(");
        }
        if(close<open){
            solve(n,ans,open,close+1,curr+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        solve(n,ans,0,0,"");
        return ans;
    }
}