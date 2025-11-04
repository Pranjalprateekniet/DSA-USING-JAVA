import java.util.Stack;
public class infixtoprefix {
    static boolean isalpha(char c){
        if(c>='a' && c<='z' || c>='A'&&c<='Z'){
            return true;
        }
        return false;
    }
    static boolean isdigit(char c){
        if(c>='0' && c<='9'){
            return true;
        }
        return false;
    }
    static boolean isOperator(char c){
       return (!isalpha(c)&&!isdigit(c));
    }
    static int getpriority(char c){
        if(c=='-' || c=='+'){
            return 1;
        }
        else if(c=='*'||c=='/'){
            return 2;
        }
        else if(c=='^'){
            return 3;
        }
        return 0;
    }
    static String reverse(char str[],int start,int end){
        char temp;
        while(start<end){
            temp=str[start];
            str[start]=str[end];
            str[end]=temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }
    static String InfixToPostfix(char[] infix1){
        System.out.println(infix1);
        String infix='('+String.valueOf(infix1)+')';
        int l=infix.length();
        Stack <Character> char_stack=new Stack < >();
        String output="";
        for(int i=0;i<l;i++){
            if(isalpha(infix.charAt(i))||isdigit(infix.charAt(i))){
                output+=infix.charAt(i);
            }
            else if(infix.charAt(i)=='('){
                char_stack.add('(');
            }
            else if(infix.charAt(i)==')'){
                while(char_stack.peek()=='('){
                output+=char_stack.peek();
                char_stack.pop();
            }
            char_stack.pop();
        }
        else{
            if(isOperator(char_stack.peek())){
                while((getpriority(infix.charAt(i))<getpriority(char_stack.peek()))||getpriority(infix.charAt(i))<=getpriority(char_stack.peek())&&infix.charAt(i)=='^'){
                    output+=char_stack.peek();
                    char_stack.pop();
                }
                char_stack.add(infix.charAt(i));
            }
        }
    }
    while(!char_stack.empty()){
        output+=char_stack.pop();
    }
    return output;

}
static String InfixToPrefix(char[] infix){
    int l=infix.length;
    String infix1=reverse(infix, 0,l-1);
    infix=infix1.toCharArray();
    for(int i=0;i<l;i++){
        if(infix[i]=='('){
                infix[i]=')';
                i++;
            }
            else if(infix[i]==')'){
                infix[i]='(';
                i++;
            }
        }
        String prefix=InfixToPostfix(infix);
        prefix=reverse(prefix.toCharArray(),0,l-1);
        return prefix;
    }
    public static void main(String[] args) {
        String s=("(p+q)*(c-d)");
        System.out.println("Infix expression: "+s);
        System.out.println("Prefix expression: ");
        System.out.println(InfixToPrefix(s.toCharArray()));
    }
}


