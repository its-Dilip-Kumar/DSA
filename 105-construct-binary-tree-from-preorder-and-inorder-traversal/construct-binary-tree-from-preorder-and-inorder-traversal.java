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
    public static int findIdx(int el,int[] ino,int n){
        for(int i=0;i<n;i++){
            if(el==ino[i]){
                return i;
            }
        }
        return -1;
    }

    public static TreeNode solve(int[] pre,int[] ino,int[] prevIdx,int start,int end,int n){
        if(start>end) return null;
        int el=pre[prevIdx[0]++];
        TreeNode root=new TreeNode(el);
        int idx=findIdx(el,ino,n);
        root.left=solve(pre,ino,prevIdx,start,idx-1,n);
        root.right=solve(pre,ino,prevIdx,idx+1,end,n);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        int[] prevIdx={0};
        return solve(preorder,inorder,prevIdx,0,n-1,n);
    }
}