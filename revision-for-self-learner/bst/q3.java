package bst;
import java.util.*;

public class q3 {
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
    private static  TreeNode buildtree(int arr[]){
        if(arr.length==0 || arr[0]==-1)
            return null;
        Queue<TreeNode>q=new LinkedList<>();
        int i=1;
        TreeNode root=new TreeNode(arr[0]);
        q.add(root);
        while(i<arr.length && !q.isEmpty()){
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
    private static List<Integer> topview(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        if(root==null)
            return ans;
        TreeMap<Integer,Integer>map=new TreeMap<>();
        Queue<Pair<TreeNode,Integer>>q=new LinkedList<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            Pair<TreeNode,Integer>it=q.poll();
            TreeNode node=it.getKey();
            int line=it.getValue();
            if(!map.containsKey(line)){
                map.put(line,node.val);
            }
            if(node.left!=null){
                q.add(new Pair<TreeNode,Integer>(node.left,line-1));

            }
            if(node.right!=null)
                q.add(new Pair<TreeNode,Integer>(node.right,line+1));


        }
        for(Integer value: map.values()){
            ans.add(value);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        TreeNode root=buildtree(arr);
        List<Integer>ans=new ArrayList<>(topview(root));
        System.out.println("The top view of the bt is : ");
        for(int i : ans){
            System.out.print(i+" ");
        }
        sc.close();
    }
}
