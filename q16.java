/*
Combination Sum II
Medium

Hints
Company
Given collection of candidate numbers (candidates) and a integer target.Find all unique combinations in candidates where the sum is equal to the target.There can only be one usage of each number in the candidates combination and return the answer in sorted order.



e.g : The combination [1, 1, 2] and [1, 2, 1] are not unique.


Example 1

Input : candidates = [2, 1, 2, 7, 6, 1, 5] , target = 8

Output : [ [1, 1, 6] , [1, 2, 5] , [1, 7] , [2, 6] ]

Explanation : The combinations sum up to target are

1 + 1 + 6 => 8.

1 + 2 + 5 => 8.

1 + 7 => 8.

2 + 6 => 8.

Example 2

Input : candidates = [2, 5, 2, 1, 2] , target = 5

Output : [ [1, 2, 2] , [5] ]

Explanation : The combinations sum up to target are

1 + 2 + 2 => 5.

5 => 5.
*/

import java.util.*;

public class q16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the target");
        int target=sc.nextInt();
        List<List<Integer>>res=combinationalsum2(arr, target);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
    private static List<List<Integer>> combinationalsum2(int arr[],int target){
        Arrays.sort(arr);
        int n=arr.length;
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        func(arr,0,n,target,temp,res);
        return res;

    }
    private static void func(int arr[],int start,int n,int target,List<Integer>temp,List<List<Integer>>res){
        if(target==0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<n;i++){
            if(i>start && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target)               
                break;
            temp.add(arr[i]);
            func(arr,i+1,n,target-arr[i],temp,res);
            temp.remove(temp.size()-1);
        }

    }
}
