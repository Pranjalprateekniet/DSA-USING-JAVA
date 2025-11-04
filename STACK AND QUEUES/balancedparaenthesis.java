import java.util.Stack;

public class balancedparaenthesis {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                st.push(i);
            } else {
                if (st.empty()) {
                    return false;
                }
                char ch = st.pop();
                if (i == ')' && ch == '(' || i == ']' && ch == '[' || i == '}' && ch == '{') {
                    continue;
                } else
                    return false;
            }
        }
        return st.empty();
    }

    public static void main(String[] args) {
        String s = "()[{}()]";
        if (isValid(s) == true) {
            System.out.println("true");
        } else {
            System.out.println("False");
        }
    }
}
