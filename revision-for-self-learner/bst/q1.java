package bst;

import java.util.*;

public class q1 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val1){
            this.val=val1;
    }        
    }
    private static TreeNode solve(TreeNode root,int val){
        if(root==null)
            return new TreeNode(val);
        if(val<root.val)
            root.left=solve(root.left,val);
        else if(val>root.val)
            root.right=solve(root.right,val);
        return root;
    }
    private static TreeNode insertnodeinabst(TreeNode root,int val){
        return solve(root,val);
    }
    private static void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        TreeNode root=null;
        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            root=solve(root,val);
        }
        System.out.println("before insertion");
        inorder(root);
        int val=sc.nextInt();
        root=insertnodeinabst(root, val);
        System.out.println("After insertion");
        inorder(root);

    }
}
