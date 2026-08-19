/*
Number of Substrings Containing All Three Characters
Hard

Hints
Company
Given a string s , consisting only of characters 'a' , 'b' , 'c'.Find the number of substrings that contain at least one occurrence of all these characters 'a' , 'b' , 'c'.


Example 1

Input : s = "abcba"

Output : 5

Explanation : The substrings containing at least one occurrence of the characters 'a' , 'b' , 'c' are "abc" , "abcb" , "abcba" , "bcba" , "cba".

Example 2

Input : s = "ccabcc"

Output : 8

Explanation : The substrings containing at least one occurrence of the characters 'a' , 'b' , 'c' are "ccab" , "ccabc" , "ccabcc" , "cab" , "cabc" , "cabcc" , "abc" , "abcc".


*/
import java.util.*;

public class q6 {
    private static int func(String s){
        int n=s.length();
        int left=0;
        int right=0;
        int c=0;
        int lastseen[]={-1,-1,-1};
        while(right<n){
            char ch=s.charAt(right);
            lastseen[ch-'a']=right;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                c=c+1+Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2]));
            }
            right++;

        }
        return c;
    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    System.out.println(func(s));
}    
}
