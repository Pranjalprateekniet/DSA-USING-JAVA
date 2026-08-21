import java.util.*;
public class q7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        int max=func(arr,n,k);
        System.out.println(max);
    }
    private static int func(int arr[],int n,int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        int left=0;
        int right=0;
        int max=0;
       
        while(right<n){
             map.put(arr[right],map.getOrDefault(arr[right], 0)+1);
            while(map.size()>k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0)
                    map.remove(arr[left]);
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
    
}
