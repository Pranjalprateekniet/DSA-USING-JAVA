import java.util.Scanner;
public class hashing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of they array");;
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int hash[] = new int[13];
        for(int i=0;i<n;i++){
            hash[arr[i]]+=1;

        }
        System.out.println("Enter the number of queries");
        int q=sc.nextInt();
        while(q-->0){
            int x=sc.nextInt();
            System.out.println(x+" is present "+hash[x]+" times");
        }
    }
}
