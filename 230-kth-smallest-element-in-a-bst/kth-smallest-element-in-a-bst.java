/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void solve(TreeNode root,ArrayList<Integer> temp){
        if(root==null) return;
        solve(root.left,temp);
        temp.add(root.val);
        solve(root.right,temp);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> temp=new ArrayList<>();
        solve(root,temp);
        int ans=0;
        for(int i=0;i<k;i++){
            ans=temp.get(i);
        }
        return ans;
    }
}