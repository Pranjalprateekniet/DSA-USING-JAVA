package bst;

import java.util.*;

public class q2 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val1){
            this.val=val1;
        }
    }
    private static TreeNode deletenode(TreeNode root,int key){
        if(root==null)
            return null;
        if(root.val==key)
            return helper(root);
        TreeNode node=root;
        while(node!=null){
            if(node.val>key){
                if(node.left!=null && node.left.val==key){
                    node.left=helper(node.left);
                    break;
                }
                else{
                    node=node.left;
                }

            }
            else{
                if(node.right!=null && node.right.val==key){
                    node.right=helper(node.right);
                    break;
                }
                else
                    node=node.right;

            }
            
        }
        return root;
    }
    private static TreeNode helper(TreeNode node){
        if(node.left==null)
            return node.right;
        if(node.right==null)
            return node.left;
        TreeNode leftchild=node.left;
        TreeNode lmc=node.right;
        while(lmc.left!=null)
            lmc=lmc.left;
        lmc.left=leftchild;
        return node.right;
    }
    private static TreeNode insertnodeinabst(TreeNode root,int val){
        if(root==null)
            return new TreeNode(val);
        if(root.val>val){
            root.left=insertnodeinabst(root.left,val);
        }
        else{
            root.right=insertnodeinabst(root.right,val);
        }
        return root;
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
            root=insertnodeinabst(root, val);
        }
        System.out.println("before deletion");
        inorder(root);
        System.out.println("Enter the val to delete");
        int key=sc.nextInt();
        root=deletenode(root, key);
        System.out.println("After deletion");
        inorder(root);
        sc.close();

    }
}
