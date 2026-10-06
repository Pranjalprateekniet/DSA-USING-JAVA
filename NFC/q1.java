import java.util.*;

public class q1 {
    public static int countGoodRotations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int k = 0; k < n; k++){
            int first = 0;
            int second = 0;
            for(int i = 0; i < n / 2; i++){
                first+= nums[(k + i) % n];
            }
            for(int i = n / 2; i < n; i++){
                second+= nums[(k + i) % n];
            }
            if(first> second)
                ans++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(countGoodRotations(arr));
    }
}
