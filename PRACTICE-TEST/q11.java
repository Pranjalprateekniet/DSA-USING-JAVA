/*

Count number of Nice subarrays
Hard

Hints
Company
Given an array nums and an integer k. An array is called nice if and only if it contains k odd numbers. Find the number of nice subarrays in the given array nums.



A subarray is continuous part of the array.


Example 1

Input : nums = [1, 1, 2, 1, 1] , k = 3

Output : 2

Explanation : The subarrays with three odd numbers are

[1, 1, 2, 1]

[1, 2, 1, 1]

Example 2

Input : nums = [4, 8, 2] , k = 1

Output : 0

Explanation : The array does not contain any odd number.

Example 3

Input : nums = [41, 3, 5] , k = 2

Output:

2
*/
import java.util.Scanner;

public class q11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        System.out.println("Enter the value of k");
        int k=sc.nextInt();
        System.out.println("no of subarrays = "+countsubarrays(arr, k));

    }
    private static int countsubarrays(int arr[],int k){
        return helper(arr,k)-helper(arr, k-1);
    }
    private static int helper(int arr[],int goal){
        if(goal<0)
            return 0;
        int left=0;
        int right=0;
        int sum=0;
        int count=0;
        while(right<arr.length){
            sum+=arr[right]%2;
            while(sum>goal){
                sum-=arr[left]%2;
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }   
}
