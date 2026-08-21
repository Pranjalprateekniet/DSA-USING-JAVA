import java.util.Scanner;

public class q8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(mypow(x, n));
    }
    private static double mypow(double x,int n){
        long num=n;
        if(num<0)
            return (1.0/power(x,-num));
        return power(x, num);

    }
    private static double power(double x,long n){
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n%2==0)
            return power(x*x,n/2);
        return x*power(x,n-1);
    }
}
