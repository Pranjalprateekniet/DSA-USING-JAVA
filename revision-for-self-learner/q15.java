import java.util.*;

public class q15 {
    static class TreeNode{
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
        q.add(root);
        int i=1;
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
    private static void leftrecursion(TreeNode root,int level,List<Integer>res){
        if(root==null)
            return;
        if(res.size()==level)
            res.add(root.val);
        leftrecursion(root.left, level+1, res);
        leftrecursion(root.right, level+1, res);
    }
    private static void rightrecursion(TreeNode root,int level,List<Integer> ans){
        if(root==null)
            return;
        if(ans.size()==level)
            ans.add(root.val);
        rightrecursion(root.right, level+1, ans);
        rightrecursion(root.left, level+1, ans);
    }
    private static List<Integer> leftsideview(TreeNode root){
        List<Integer> res=new ArrayList<>();
        leftrecursion(root,0,res);
        return res;
    }
    private static List<Integer> rightsideview(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        rightrecursion(root, 0, ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        TreeNode root=buildtree(arr);
        List<Integer> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        ans=leftsideview(root);
        res=rightsideview(root);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<res.size();i++)
            System.out.print(res.get(i)+" ");
        sc.close();
    }
}
