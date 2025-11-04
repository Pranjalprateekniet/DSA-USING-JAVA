import java.util.Scanner;
public class pattern {
    public static void main(String[] args) {
        

    Scanner sc=new Scanner(System.in);
    System.out.println("Entter number of rows you want to print");
    int n=sc.nextInt();
    int spaces=2*(n-1);
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            System.out.print(j+" ");
        }
        for(int l=1;l<=spaces;l++){
            System.out.print(" ");
        }
        for(int k=i;k>=1;k--){
            System.out.print(k+" ");
        }
            System.out.println();
    spaces-=2;
    }


    }}
