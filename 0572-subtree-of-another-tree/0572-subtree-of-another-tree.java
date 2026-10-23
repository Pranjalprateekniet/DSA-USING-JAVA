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
    private boolean helper(TreeNode root,TreeNode subroot){
        if(root==null && subroot==null)
            return true;
        if(root==null || subroot==null)
            return false;
        if(root.val!=subroot.val)
            return false;
        return helper(root.left,subroot.left) && helper(root.right,subroot.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        int num=subroot.val;
        TreeNode start=finder(root,num,subroot);
        return helper(start,subroot);
    }
    private TreeNode finder(TreeNode root,int num,TreeNode subroot){
        if(root==null)
            return null;
        if(root.val==num && helper(root,subroot))
            return root;
        TreeNode left=finder(root.left,num,subroot);
        if(left!=null)
            return left;
        return finder(root.right,num,subroot);
    }
}