import java.util.*;

public class q15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("enter the elemets");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        System.out.println("enter the target");
        int target=sc.nextInt();
        List<List<Integer>>res=combinationalsum(arr, target);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i));
        }
    }
    private static List<List<Integer>> combinationalsum(int arr[],int target){
        int n=arr.length;
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        func(arr,n,0,target,0,temp,res);
        return res;
    }
    private static void func(int arr[],int n,int i,int target,int sum,List<Integer>temp,List<List<Integer>>res){
        if(i==n)
        {
            if(sum==target)
            {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        func(arr,n,i+1,target,sum,temp,res);
        if(arr[i]+sum<=target){
            temp.add(arr[i]);
            sum+=arr[i];
            func(arr,n,i,target,sum,temp,res);
            temp.remove(temp.size()-1);
            sum=sum-arr[i];
        }
        return;
    }
}
