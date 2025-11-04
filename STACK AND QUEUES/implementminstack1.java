
//this implementation of min stack is using brute force method
//the next program on this will have optimal approach.
import java.util.Stack;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class implementminstack1 {
    Stack<Pair> st;

    public implementminstack1() {
        st = new Stack<>();
    }

    public void push(int x) {
        int min;
        if (st.isEmpty()) {
            min = x;
        } else {
            min = Math.min(st.peek().y, x);
        }
        st.push(new Pair(x, min));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().x;
    }

    public int getMin() {
        return st.peek().y;
    }

    public static void main(String[] args) {
        implementminstack1 ms = new implementminstack1();

        ms.push(5);
        ms.push(2);
        ms.push(8);
        ms.push(1);

        System.out.println("Top: " + ms.top()); // 1
        System.out.println("Min: " + ms.getMin()); // 1

        ms.pop();
        System.out.println("Top: " + ms.top()); // 8
        System.out.println("Min: " + ms.getMin()); // 2
    }
}
