import java.util.Stack;
public class infixtopostfix {
    static int Prec(char ch){
        switch (ch){
            case '+':
            case '-':
            return 1;
            case '*':
            case '/':
            return 2;
            case '^':
            return 3;
        }
        return -1;
    }
    static String InfixToPostfix(String exp){
        String results=new String("");
        Stack <Character> s=new Stack < > ();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c))
            results +=c;
            else if(c=='('){
                s.push(c);
            }
            else if(c==')'){
            while(!s.isEmpty() && s.peek()!='('){
                results +=s.pop();
            }
            s.pop();
            }
            else
            {
                while(!s.isEmpty() && Prec(c)<=Prec(s.peek())){
                    results+=s.pop();
                }
                s.push(c);
            }
            }
            while (!s.isEmpty()) {
                if(s.peek()=='(')
                return "Invalid expression";
                results+=s.pop();
            }
            return results;
        }
        public static void main(String[] args) {
            String exp="(p+q)*(m-n)";
            System.out.println("Infix expression = "+exp);
            System.out.println("Postfix expression "+InfixToPostfix(exp));
        }
    }

