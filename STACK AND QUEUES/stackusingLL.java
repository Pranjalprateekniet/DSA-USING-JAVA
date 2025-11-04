class StacksuingLinkedLists{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private Node top;
    private int size;
    public StacksuingLinkedLists(){
        top=null;size=0;

    }
    public void push(int value){
        Node temp=new Node(value);
        temp.next=top;
        top=temp;
        size++;
        System.out.println(value+" pushed to stack");
    } 
    public int pop(){
        if(size==0){
            System.out.println("Stack is empty");
            return -1;
        }
        int value=top.data;
        top=top.next;
        size--;
        System.out.println(value+ " popped from stack");
        return value;
    }
    public int topp(){
        if(size==0){
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
    public int size(){
        return size;
    }

    public void disp(){
        if(size==0){
            System.out.println("Stack is empty");
            return;
        }
         Node current=top;
         System.out.println("Top -> ");
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();

    }
}

public class stackusingLL {
    public static void main(String[] args) {
        StacksuingLinkedLists s=new StacksuingLinkedLists();
        s.push(69);
        s.push(56);
        s.push(58);
        s.push(45);
        s.disp();
        System.out.println("top element of stack is : "+s.topp());
        s.pop();
        s.disp();
        System.out.println(s.size());
        s.pop();
        s.pop();
        s.pop();
        s.pop();

    }
}