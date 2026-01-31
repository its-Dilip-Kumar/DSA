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
    public static void inorder(TreeNode root,ArrayList<Integer> ans){
        if(root==null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return true;
        ArrayList<Integer> ans=new ArrayList<>();
        inorder(root,ans);
        int left=0;
        int right=ans.size()-1;
        while(left<right){
            int sum=ans.get(left)+ans.get(right);
            if(sum==k) return true;
            if(sum<k){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}