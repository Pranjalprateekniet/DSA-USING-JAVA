/*
Longest Substring With At Most K Distinct Characters
Hard

Hints
Company
Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters.


Example 1

Input : s = "aababbcaacc" , k = 2

Output : 6

Explanation : The longest substring with at most two distinct characters is "aababb".

The length of the string 6.

Example 2

Input : s = "abcddefg" , k = 3

Output : 4

Explanation : The longest substring with at most three distinct characters is "bcdd".

The length of the string 4.
*/
import java.util.*;
public class q5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        int k=sc.nextInt();
        System.out.println(func(s, n,k));

    }
    private static int func(String s,int n,int k){
        int left=0;
        int right =0;
        int max=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(right<n){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            while(map.size()>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)
                    map.remove(s.charAt(left));
                left++;
            }
            max=Math.max(right-left+1,max);
            right++;
        }
        return max;
    }
    
}
