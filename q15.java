/*

Combination Sum
Medium

Hints
Company
Provided with a goal integer target and an array of unique integers nums, provide a list of all possible combinations of nums in which the selected numbers add up to the target. The combinations can be returned in any order.



A number may be selected from nums an infinite number of times. There are two distinct combinations if the frequency of at least one of the selected numbers differs.



The test cases are created so that, for the given input, there are fewer than 150 possible combinations that add up to the target.



If there is no possible combination, then return an empty vector.


Example 1

Input : nums = [2, 3, 5, 4] , target = 7

Output : [ [2, 2, 3], [2, 5] , [3, 4] ]

Explanation :

2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.

2 and 5 are candidates, and 2 + 5 = 7.

3 and 4 are candidates, and 3 + 4 = 7.

There are total three combinations.

Example 2

Input : nums = [2], target = 1

Output : []

Explanation : There is no way we can choose the candidates to sum up to target.*/


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
