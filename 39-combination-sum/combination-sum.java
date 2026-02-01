class Solution {
    public static void solve(int idx,int[] nums,List<List<Integer>> ans,List<Integer> temp,int target,int sum){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx>=nums.length || sum>target){
            return;
        }
        temp.add(nums[idx]);
        solve(idx,nums,ans,temp,target,sum+nums[idx]);
        temp.remove(temp.size()-1);
        solve(idx+1,nums,ans,temp,target,sum);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(0,candidates,ans,temp,target,0);
        return ans;
    }
}