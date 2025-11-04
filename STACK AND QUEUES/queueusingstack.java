import java.util.LinkedList;
import java.util.Stack;

class MYQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MYQueue() {

    }

    public void push(int x) {
        System.out.println("The element is pushed " + x);
        s1.push(x);
    }

    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.peek());
                s1.pop();
            }

        }
        int x = s2.peek();
        s2.pop();
        return x;
    }

    public int top() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.peek());
                s1.pop();
            }
        }
        return s2.peek();
    }

    int size() {
        return (s1.size() + s2.size());
    }
}

public class queueusingstack {
    public static void main(String[] args) {
        MYQueue q = new MYQueue();
        q.push(3);
        q.push(8);
        System.out.println("The element is popped " + q.pop());
        q.push(45);
        System.out.println("The top element is " + q.top());
        System.out.println("The size of queue is " + q.size());
    }
}
