import java.util.Scanner;

public class reversenumber{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int n=sc.nextInt();
        int s=0;
        for(int i=n;i>0;i=i/10){//658
            int r=i%10;//mod is always = remainder
            s=s*10+r;
        }
        System.out.println("The reverse is ="+s);
    }
}