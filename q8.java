/*
Power Set
Medium

Hints
Company
Given an array of integers nums of unique elements. Return all possible subsets (power set) of the array.



Do not include the duplicates in the answer.


Example 1

Input : nums = [1, 2, 3]

Output : [ [ ] , [1] , [2] , [1, 2] , [3] , [1, 3] , [2, 3] , [1, 2 ,3] ]

Example 2

Input : nums = [1, 2]

Output : [ [ ] , [1] , [2] , [1,2] ]

Now your turn!



*/

import java.util.*;
public class q8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        List<List<Integer>>res=new ArrayList<>();
        res=powerset(arr);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
    private static List<List<Integer>> powerset(int[] arr){
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        int n=arr.length;
        func(arr, 0, n, temp, res);
        return res;
        
    }
    private static void func(int arr[],int i,int n,List<Integer>temp,List<List<Integer>>res){
        if(i==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        func(arr,i+1,n,temp,res);
        temp.add(arr[i]);
        func(arr,i+1,n,temp,res);
        temp.remove(temp.size()-1); 
        return;
    }
}
