class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int n=s.length();
        int right =0;
        int maxfreq=0;
        int maxlen=0;
        int hash[]=new int[26];
        while(right<n){
            hash[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,hash[s.charAt(right)-'A']);
            if(right-left+1-maxfreq>k){
                hash[s.charAt(left)-'A']--;
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
        
    }
}