
class Node{
    int data;
    Node next;
    Node (int data1, Node next1){
        this.data=data1;
        this.next=next1;

    }
    Node(int data1){
        this.data=data1;
        this.next=null;
    }
}


public class p1 {
    public static void main(String[] args) {
        int [] arr={2,6,78,112};
        Node y=new Node(arr[2]);
        System.out.println(y.data);
        System.out.println(y.next);
    }
}
