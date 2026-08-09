public class pattern1 {
    public static void main(String[] args) {
        char ch='E';
        for(int i=1;i<=5;i++){
            char start=ch;
            for(int j=1;j<=i;j++){
                System.out.print(start);
                start++;
            }
                ch--;
                System.out.println();
        }
    }
 }