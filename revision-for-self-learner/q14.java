import java.util.*;

public class q14 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val1){
            this.val=val1;
        }
    }
    static class Pair<K,V>{
        private K key;
        private V value;

        public Pair(K key,V value){
            this.key=key;
            this.value=value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
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
            if(i<arr.length && arr[i]!=-1){
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
        
    private static List<Integer>  bottomview(TreeNode root){
        List<Integer>res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        Map<Integer,Integer>map=new TreeMap<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            Pair<TreeNode,Integer> it=q.poll();
            TreeNode node=it.getKey();
            int line=it.getValue();
            map.put(line,node.val);
            if(node.left!=null)
                q.add(new Pair<>(node.left,line-1));
            if(node.right!=null)
                q.add(new Pair<>(node.right,line+1));
        }
        for(Integer value : map.values()){
            res.add(value);
        }
        return res;
    }   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        TreeNode root=buildtree(arr);
        List<Integer> ans=new ArrayList<>();
        ans=bottomview(root);
        for(int i:  ans){
            System.out.print(i+" ");
        }
        sc.close();
    }

}
