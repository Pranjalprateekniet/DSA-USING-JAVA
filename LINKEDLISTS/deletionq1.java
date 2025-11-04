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
public class deletionq1{
    public static Node convertarr2ll(int[] arr){
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
        while(head!=null){
            System.out.print(head.data+" ");

            head=head.next;
        }
        System.out.println();

}
public static Node removeshead(Node head)
{
    if(head==null){
        return head;
    }
    head=head.next;
    return head;
}

public static void main(String[] args) {
    int arr[]={12,54,69,37,54};
    Node head=convertarr2ll(arr);
    head=removeshead(head);
    print(head);
}
}