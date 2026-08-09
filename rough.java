import java.util.Scanner;

class Subject{
    int max =100;
    int obtd;
}

public class rough {
    public static void main(String[] args) {
        Subject s1 = new Subject();
        System.out.println("Enter Maths Marks:");
        Scanner sc=new Scanner(System.in);
        s1.obtd=sc.nextInt();
        Subject s2 = new Subject();
        System.out.println("Enter Physics Marks:");
        // Scanner sc = new Scanner(System.in);
        s2.obtd=sc.nextInt();
        Subject s3 = new Subject();
        System.out.println("Enter Chemistry Marks:");
        s3.obtd=sc.nextInt();
        Subject s4 = new Subject();
        System.out.println("Enter English Marks:");
        s4.obtd=sc.nextInt();
        Subject s5 = new Subject();
        System.out.println("Enter Hindi Marks:");
        s5.obtd=sc.nextInt();
        int tobtd = (s1.obtd)+(s2.obtd)+(s3.obtd)+(s4.obtd)+(s5.obtd);
        double per = (tobtd*100/500);
        System.out.println("Percentage obtaind :"+per);

       




    }
}