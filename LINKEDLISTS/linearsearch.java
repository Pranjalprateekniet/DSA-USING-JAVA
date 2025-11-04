import java.util.Scanner;
public class linearsearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter lenght of array");
        int n=sc.nextInt();
        System.out.println("Enter elements for the array");
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter target element");
        int target=sc.nextInt();
        int c=0;
        for(int i=0;i<n;i++){
            if (arr[i]==target){
                System.out.println("target found at index "+i);
                c++;
                break;
            }
        }
        if (c!=1)
        System.out.println("target not found");
        sc.close();
    }
}
