class Node{
    int data;
    Node next;
    Node(int data1,Node next1){
        data=data1;
        next=next1;
    }
    Node(int data1){
        data=data1;
        next=null;
    }
}
public class insertionq1 {
    public static Node convertarr2LL(int[] arr){
        Node head=new Node(arr[0]);
        Node mover=head;
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
      }
      public static void print(Node head){
        while (head!=null) {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
}
public static Node insertHead(Node head,int val){
    return new Node(val,head);
}
public static Node insertTail(Node head,int val){
    if(head==null){
        return new Node(val);
    }
    Node temp=head;
    while(temp.next !=null){
        temp=temp.next;
    }
    Node newNode=new Node(val);
    temp.next=newNode;
    return head;
}
public static void main(String[] args) {
    int[] arr={12,54,22,58,35};
    Node head=convertarr2LL(arr);
   // System.out.println("to insert head in a LL");
   // head=insertHead(head,69);
   // print(head);
    System.out.println("To insert an element at the tail of the LL");
    head=insertTail(head, 69);
    print(head);
}
}
