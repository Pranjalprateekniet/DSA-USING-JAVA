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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=helper(preorder,0,n-1,map);
        return root;
    }
    private TreeNode helper(int preorder[],int start,int end,HashMap<Integer,Integer>map){
        if(start>end)
            return null;
        int rootval=preorder[index];
        index++;
        TreeNode node=new TreeNode(rootval);
        int inorderindex=map.get(rootval);
        node.left=helper(preorder,start,inorderindex-1,map);
        node.right=helper(preorder,inorderindex+1,end,map);
        return node;
    }
}