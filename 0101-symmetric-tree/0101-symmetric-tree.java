/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    private static boolean ismirror(TreeNode n1,TreeNode n2){
        if(n1==null && n2==null)
            return true;
        if(n1==null || n2==null)
            return false;
        return n1.val==n2.val && ismirror(n1.left,n2.right)&& ismirror(n1.right,n2.left);

    }
    public boolean isSymmetric(TreeNode root) {
        //your code goes here
        return ismirror(root.left,root.right);
    }
}