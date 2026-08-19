import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        System.out.println(maxscore(arr, n,k));

    }
    private static int maxscore(int arr[],int n,int k){
        int prefix=0;
        for(int i=0;i<k;i++){
            prefix+=arr[i];
        }
        int sum=prefix;
        int max=prefix;
        int left=k-1;
        int right=arr.length-1;
        for(int i=0;i<k;i++){
            sum=sum-arr[left];
            sum=sum+arr[right];
            left--;
            right--;
            max=Math.max(sum,max);
        }
        return max;
    }
    
}
