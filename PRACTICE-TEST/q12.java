/*
Binary Subarrays With Sum
Hard

Hints
Company
Given a binary array nums and an integer goal. Return the number of non-empty subarrays with a sum goal.



A subarray is a continuous part of the array.


Example 1

Input : nums = [1, 1, 0, 1, 0, 0, 1] , goal = 3

Output : 4

Explanation : The subarray with sum 3 are

[1, 1, 0, 1]

[1, 1, 0, 1, 0]

[1, 1, 0, 1, 0, 0]

[1, 0, 1, 0, 0, 1].

Example 2

Input : nums = [0, 0, 0, 0, 1] , goal = 0

Output : 10

Explanation : Some of the subarray with sum 0 are

[0]

[0, 0]

[0, 0, 0]

[0, 0, 0, 0]

Constraints

1 <= nums.length <= 3*104
0 <= goal <= nums.length
nums consist of only 0 and 1.

*/


import java.util.Scanner;

public class q12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("enther the subarray values");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        System.out.println("enter the value of k");
        int k=sc.nextInt();
        System.out.println(countsubarrays(arr, k));
    }
    private static int countsubarrays(int arr[],int k){
        return helper(arr,k)-helper(arr,k-1);
    }
    private static int helper(int arr[],int k){
        if(k<0){
            return 0;
        }
        int left=0;
        int right=0;
        int c=0;
        int sum=0;
        while(right<arr.length){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left++;
            }
            c+=(right-left+1);
            right++;
        }
        return c;
    }
}
