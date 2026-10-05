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
    private static void inorder(TreeNode root,List<Integer>list){
        if(root==null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer>ans=new ArrayList<>();
        inorder(root,ans);
        int res=ans.get(k-1);
        return res;
    }
}