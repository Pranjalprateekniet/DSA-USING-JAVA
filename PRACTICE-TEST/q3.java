/*
Max Consecutive Ones III
Medium

Hints
Company
Given a binary array nums and an integer k, flip at most k 0's.

Return the maximum number of consecutive 1's after performing the flipping operation.


Example 1

Input : nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] , k = 3

Output : 10

Explanation : The maximum number of consecutive 1's are obtained only if we flip the 0's present at position 3, 4, 5 (0 base indexing).

The array after flipping becomes [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0].

The number of consecutive 1's is 10.

Example 2

Input : nums = [0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1] , k = 3

Output : 9

Explanation : The underlines 1's are obtained by flipping 0's in the new array.

[1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1].

The number of consecutive 1's is 9.

*/

import java.util.*;
public class q3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        System.out.println(maxlength(arr,n,k));
    }
    private static int maxlength(int arr[],int n,int k){
        int left=0;
        int right =0;
        int max=0;
        int flips=0;
        while(right<n){
            if(arr[right]!=1)
                flips++;
            while(flips>k){
                if(arr[left]==0)
                    flips--;
                left++;
            }
            int curr=right-left+1;
            max=Math.max(curr,max);
            right++;
            
        }
        return max;
    }
    
}
