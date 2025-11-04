import java.util.*;
class Stack{
    int size=10000;
    int arr[]=new int[size];
    int top=-1;
    void push(int x){
        top++;
        arr[top]=x;
        }
        int pop(){
            int x=arr[top];
            top--;
            return x;
        }
        int top(){
            return arr[top];
        }
        int size(){
            return top+1;
        }
}
public class p1 {
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(14);
        s.push(7);
        s.push(69);
        System.out.println("top of stack before deleting any element = "+s.top());
        System.out.println("Size of stack before deleteing any elemnts"+s.size());
        System.out.println("The element getting deleted is : "+s.pop());
        System.out.println("Top of stack after deleting an element from the stack : "+s.top());
        System.out.println("Size of stack after deleting an element is : "+s.size());
    }
    
}
