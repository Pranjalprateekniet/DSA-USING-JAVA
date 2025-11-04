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
public class lengthofLL {
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
    public static int Lengthofll(Node head){
        int c=0;
        Node temp=head;
        while(temp !=null){
            temp=temp.next;
            c++;
        }
        return c;
    }
    public static int searchanelement(Node head,int val){
        Node temp=head;
        while(temp!=null){
            if(temp.data==val){
                return 1;
            }
            temp=temp.next;
        }
         return 0;
    }
    public static void main(String[] args) {
        int[] arr={12,54,29,78,69};
        Node head=convertarr2LL(arr);
        Node temp=head;
        System.out.println(Lengthofll(head));
        while(temp !=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        System.out.println(searchanelement(head,69 )+" value is present");
    }
}
