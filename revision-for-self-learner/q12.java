import java.util.*;
public class q12 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val1){
            this.val=val1;
        }
    }
    private static TreeNode buildtree(int arr[]){
        if(arr.length==0 || arr[0]==-1)
            return null;
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(arr[0]);
        int i=1;
        q.add(root);
        while(i<arr.length){
            TreeNode curr=q.poll();
            if(i<arr.length && arr[i]!=-1)
            {
                curr.left=new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;
            if(i<arr.length && arr[i]!=-1){
                curr.right=new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    private static boolean isleaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    private static void leftnodes(TreeNode root,List<Integer>res){
        TreeNode curr=root.left;
        while(curr!=null){
            if(!isleaf(curr))
                res.add(curr.val);
            if(curr.left!=null)
            {
                curr=curr.left;
            }
            else
                curr=curr.right;
        }
    }
     private static void rightnodes(TreeNode root,List<Integer>res){
        TreeNode curr=root.right;
        List<Integer>temp=new ArrayList<>();
        while(curr!=null){
            if(!isleaf(curr)){
                temp.add(curr.val);
            }
            if(curr.right!=null)
                curr=curr.right;
            else
                curr=curr.left;

        }
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }
    private static void addleaves(TreeNode root,List<Integer>res){
        if(isleaf(root))
        {
            res.add(root.val);
            return;
        }
        if(root.left!=null){
            addleaves(root.left, res);
        }
        if(root.right!=null)
            addleaves(root.right, res);
    }
    private static List<Integer> boundrytraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return null;
        if(!isleaf(root))
            res.add(root.val);
        leftnodes(root, res);
        addleaves(root, res);
        rightnodes(root, res);
        return res;
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        TreeNode root=buildtree(arr);
        List<Integer>ans=new ArrayList<>();
        ans=boundrytraversal(root);
        for(int i=0;i<ans.size();i++)
            System.out.print(ans.get(i)+" ");
        sc.close();
    }
}
