import java.util.*;
public class q9 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data1){
            this.data=data1;
        }

        
    }
    private static Node buildtree(int[] arr){
        if(arr.length==0 || arr[0]==-1)
            return null;
        Node root=new Node(arr[0]);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(i<arr.length){
            Node current=q.poll();
            if(i<arr.length){
                current.left=new Node(arr[i]);
                q.add(current.left);
                i++;
            }
            if(i<arr.length){
                current.right=new Node(arr[i]);
                q.add(current.right);
                i++;
            }
        }
        return root;

    }
    static int diameter=0;
    private static int height(Node root){
        if(root==null)
            return 0;
        int left=height(root.left);
        int right=height(root.right);
        diameter=Math.max(diameter,left+right);
        return 1+Math.max(left,right);
        
    }
    private static int diameterofthebinarytree(Node root){
        height(root);
        return diameter;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter -1 for null");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Node root=buildtree(arr);
        int ans=diameterofthebinarytree(root);
        System.out.println("Diameter = "+ans);
    }
}
