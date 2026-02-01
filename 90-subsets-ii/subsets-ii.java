class Solution {
    public static void solve(int idx,int[] nums,List<List<Integer>> ans,List<Integer> temp){
        if(idx>=nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(idx+1,nums,ans,temp);
        temp.remove(temp.size()-1);
        while(idx+1<nums.length && nums[idx]==nums[idx+1]){
            idx++;
        }
        solve(idx+1,nums,ans,temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(0,nums,ans,temp);
        return ans;
    }
}