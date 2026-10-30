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
    public List<List<Integer>> pathSum(TreeNode root, int targetsum) {
        List<List<Integer>>ans=new ArrayList<>();
        dfs(root,targetsum,0,ans,new ArrayList<>());
        return ans;
    }
    private void dfs(TreeNode root,int targetsum,int currsum,List<List<Integer>>ans,List<Integer>currpath){
        if(root==null)
            return;
        currsum+=root.val;
        currpath.add(root.val);
        if(root.left==null && root.right==null && currsum==targetsum)
            ans.add(new ArrayList<>(currpath));
        dfs(root.left,targetsum,currsum,ans,currpath);
        dfs(root.right,targetsum,currsum,ans,currpath);
        currpath.remove(currpath.size()-1);

    }
}