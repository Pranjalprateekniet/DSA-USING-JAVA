class Queue{
    private int arr[];
    private int start,end,currSize,maxSize;
    public Queue(){
        arr=new int[10];
        start=-1;
        end=-1;
        currSize=0;
    }
    public Queue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        start=-1;
        end=-1;
        currSize=0;
    }
    public void push(int newElement){
        if(currSize==maxSize){
            System.out.println("Queue if full");
            System.exit(1);
        }
        if(end==-1){
            start=0;
            end=0;
        }
        else{
            end=(end+1)%maxSize;
        }
        arr[end]=newElement;
        System.out.println("The element pushed is : "+newElement);
        currSize++;
    }
    public int pop(){
        if(start == -1){
            System.out.println("Queue empty ");
            System.exit(1);
        }
        int popped=arr[start];
        if(currSize==1){
            start=-1;
            end=-1;
        }
        else{
            start=(start+1)%maxSize;
        }
        currSize--;
        return popped;
    }
    public int top(){
        if (currSize==-1){
            System.out.println("Queue is empty");
            System.exit(1);
        }
        return arr[start];
    }
    public int size(){
        return currSize;
    }
}
public class p1queueimple {
    public static void main(String[] args) {
        Queue q=new Queue(6);
        q.push(6);
        q.push(8);
        q.push(69);
        q.push(96);
        q.push(34);
        System.out.println("The peak of array before any alterations : "+q.top());
        System.out.println("the size of queue before deleting anything : "+q.size());
        System.out.println("The first element to be deleted : "+q.pop());
        System.out.println("the peak of queue after deleting an element : "+q.top());
        System.out.println("The size of the queue after deleting an element : "+q.size());
    }
}