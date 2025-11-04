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
public class deletionq4 {
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
    public static Node removeselement(Node head, int el){
        if(head.data==el){
            Node temp=head;
            head=head.next;
            return head;
        }
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            if(temp.data==el){
            prev.next=prev.next.next;
            break;
        }
        prev=temp;
        temp=temp.next;
    }
    return head;
    }
public static void main(String[] args) {
        int arr[]={12,54,69,37,54};
    Node head=convertarr2LL(arr);
    head=removeselement(head,69);
    print(head);
}

}