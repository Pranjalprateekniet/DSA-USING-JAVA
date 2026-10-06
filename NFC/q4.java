import java.util.*;
    public class q4 {
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

    private static  TreeNode buildtree(TreeNode root,int val){
        if(root==null)
            return new TreeNode(val);
        if(root.val>val){
            root.left=buildtree(root.left,val);
        }
        else{
            root.right=buildtree(root.right,val);
        }
        return root;
    
    }
    private static void inordertraversal(TreeNode root,List<Integer>ino){
        if(root==null)
            return;
        inordertraversal(root.left,ino);
        ino.add(root.val);
        inordertraversal(root.right,ino);
    }
    private static List<Integer> inorder(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        if(root==null)
            return ans;
        inordertraversal(root, ans);
        return ans;
    }
    private static void leftrecursion(TreeNode root,int level,List<Integer>lv){
        if(root==null)
            return;
        if(lv.size()==level)
            lv.add(root.val);
        leftrecursion(root.left, level+1, lv);
        leftrecursion(root.right, level+1, lv);
    }
    private static List<Integer>leftview(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        if(root==null)
            return ans;
        leftrecursion(root, 0, ans);
        return ans;
    }

    private static void rightrecursion(TreeNode root,int level,List<Integer>rv){
        if(root==null)
            return;
        if(rv.size()==level)
            rv.add(root.val);
        rightrecursion(root.right, level+1, rv);
        rightrecursion(root.left, level+1, rv);
    }
    private static List<Integer>rightview(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        rightrecursion(root, 0, ans);
        return ans;
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
    private static List<Integer>bottomview(TreeNode root){
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
            map.put(line,node.val);
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
        TreeNode root=null;
        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            root=buildtree(root, val);
        }
        List<Integer>tp=new ArrayList<>(topview(root));
        System.out.println("The top view of the bst is : ");
        for(int i : tp){
            System.out.print(i+" ");
        }
        System.out.println();
        List<Integer>bv=new ArrayList<>(bottomview(root));
        System.out.println("Bottom view of the bst is : ");
        for(int i: bv)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("Left view of a bst is");
        
        List<Integer>lv=new ArrayList<>(leftview(root));
        for(int i : lv){
            System.out.print(i+" ");

        }System.out.println();
        System.out.println("The right view of the bst is : ");
        List<Integer>rv=new ArrayList<>(rightview(root));
        for(int i : rv){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("inorder traversal");
        List<Integer>ino=new ArrayList<>(inorder(root));
        for(int i : ino){
            System.out.print(i+" ");
        }

    }
}
