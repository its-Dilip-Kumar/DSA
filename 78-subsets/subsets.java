class Solution {
    public static void solve(int idx,int[] nums,List<List<Integer>> ans,List<Integer> list){
        if(idx>=nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        solve(idx+1,nums,ans,list);
        list.remove(list.size()-1);
        solve(idx+1,nums,ans,list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        solve(0,nums,ans,list);
        return ans;
    }
}