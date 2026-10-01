import java.util.LinkedList;
import java.util.Queue;

public class q10 {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data1){
            this.data=data1;
        }
    }
    private Node buildtree(int arr[]){
        if(arr.length==0 || arr[0]==-1)
            return null;
        Node root=new Node(arr[0]);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(i<arr.length){
            Node curr=q.poll();
            if(i<arr.length && arr[i]!=-1){
                curr.left=new Node(arr[i]);
                q.add(curr.left);
            }
            i++;
            if(i<arr.length && arr[i]!=-1){
                curr.right=new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    private static int pathsum(Node root,int[] max){
        if(root==null)
            return 0;
        int left=Math.max(0,pathsum(root.left, max));
        int right=Math.max(0,pathsum(root.right, max));
        

    }
    private static int maxpathsum(Node root){
        int max[]=new int[1];
        max[0]=Integer.MIN_VALUE;
    }
}
