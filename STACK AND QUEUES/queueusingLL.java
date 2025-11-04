class QueueNode{
        int data;
        QueueNode next;
        QueueNode(int data1){
            data=data1;
            next=null;
        }
}
class Queue{
    QueueNode Front=null,Rear=null;
    int size=0;
    boolean Empty(){
        return Front==null;
    }
    int top(){
        if(Empty()){
            return -1;
        }
        else
        return Front.data;
    }
    void push(int value){
        QueueNode Temp;
        Temp=new QueueNode(value);
        if(Temp==null){
            System.out.println("Queue is full");
        }
        else{
            if(Front==null){
                Front=Temp;
                Rear=Temp;
            }
            else{
                Rear.next=Temp;
                Rear=Temp;
            }
            System.out.println(value+" Inserted into queue");
            size++;
        }

    }
    void pop(){
        if(Front == null){
            System.out.println("Queue is Empty");
        }
        else{
            System.out.println(Front.data+" Removed from Queue");
            QueueNode Temp=Front;
            Front=Front.next;
            size--;
        }
    }
}
public class queueusingLL {
    public static void main(String[] args) {
        Queue q=new Queue();
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);
        q.pop();
        System.out.println("The size of queue is "+q.size);
        System.out.println("The top element of the queue is "+q.top());
    }
}
