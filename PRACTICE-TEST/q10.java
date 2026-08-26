/*
Longest Substring with K Uniques
Solved
Difficulty: MediumAccuracy: 34.65%Submissions: 332K+Points: 4
You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1. 

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26

*/
import java.util.*;
public class q10 {
    private static int longestKSubstr(String s, int k) {
        // code here
        int n=s.length();
        int left=0;
        int right=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int max=-1;
        while(right<n){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>k){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                if(map.get(s.charAt(left))==0)
                    map.remove(s.charAt(left));
                left++;
            }
            if(map.size()==k){
                max=Math.max(right-left+1,max);
            }
            right++;
            
        }
        return max;
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        String s=sc.next();
        int ans=longestKSubstr(s,k);
        System.out.println(ans);


    }
    
}
