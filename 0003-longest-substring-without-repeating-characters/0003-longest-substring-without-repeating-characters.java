class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
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