/*
Longest Substring Without Repeating Characters
Medium

Hints
Company
Given a string, S. Find the length of the longest substring without repeating characters.


Example 1

Input : S = "abcddabac"

Output : 4

Explanation : The answer is "abcd" , with a length of 4.

Example 2

Input : S = "aaabbbccc"

Output : 2

Explanation : The answers are "ab" , "bc". Both have maximum length 2.


*/
import java.util.*;
public class q2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        System.out.println(longestsubstring(s, n));
    }

    private static int longestsubstring(String s,int n){
        int left=0;
        int right=0;
        int max=0;
        HashSet<Character> set=new HashSet<>();
        while(right<n){
            char ch=s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            int curr=right-left+1;
            max=Math.max(curr,max);
            right++;

        }
        return max;
    }
    
}
