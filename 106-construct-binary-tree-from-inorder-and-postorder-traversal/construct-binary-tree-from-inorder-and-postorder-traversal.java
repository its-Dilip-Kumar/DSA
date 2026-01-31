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
            if(el==ino[i]) return i;
        }
        return -1;
    }
    public static TreeNode solve(int[] ino,int[] pos,int[] postIdx,int start,int end,int n){
        if(start>end) return null;
        int el=pos[postIdx[0]--];
        TreeNode root=new TreeNode(el);
        int idx=findIdx(el,ino,n);
        root.right=solve(ino,pos,postIdx,idx+1,end,n);
        root.left=solve(ino,pos,postIdx,start,idx-1,n);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        int[] postIdx={n-1};
        return solve(inorder,postorder,postIdx,0,n-1,n);
    }
}