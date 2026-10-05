import java.util.*;
public class q16 {
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

    private static int widthofbinarytree(TreeNode root){
        if(root==null)
            return 0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        long maxwidth=0;
        while(!q.isEmpty()){
            int size=q.size();
            long left=q.peek().value;
            long right

        }
    }
    public static void main(String[] args) {
        
    }
}
