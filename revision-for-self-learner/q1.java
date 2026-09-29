import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data1,Node next1){
        this.data=data1;
        this.next=next1;

    }
    Node(int data1){
        this.data=data1;
        this.next=null;
    }
}
class solution{
    private static Node createlist(int[] arr){
        Node head=new Node(arr[0]);
        Node curr=head;
        for(int i=1;i<arr.length;i++){
            curr.next=new Node(arr[i]);
            curr=curr.next;

        }
        return head;

    }
    private static Node addtwonumbers(Node l1,Node l2){
        Node dummy=new Node(-1);
        Node curr=dummy;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum=carry;
            if(l1!=null){
                sum=sum+l1.data;
                l1=l1.next;

            }
            if(l2!=null){
                sum=sum+l2.data;
                l2=l2.next;
            }
            Node newNode=new Node(sum%10);
            carry=sum/10;
            curr.next=newNode;
            curr=curr.next;



        }
        if(carry!=0){
            Node newnode=new Node(carry);
            curr.next=newnode;
        }
        return dummy.next;
    }
    private static void printlist(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int arr1[]=new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }
        int n2=sc.nextInt();
        int arr2[]=new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i]=sc.nextInt();

        }
        Node l1=createlist(arr1);
        Node l2=createlist(arr2);
        Node ans=addtwonumbers(l1, l2);
        printlist(ans);

        

    }
}