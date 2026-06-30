class Solution {
    public int numberOfSubstrings(String s) {
        int left =0;
        int right=0;
        int n=s.length();
        int tot=0;
        int[] freq=new int[3];
        while(right<n){
            char ch=s.charAt(right);
            ++freq[ch-'a'];
            while(freq[0]>0 & freq[1]>0 && freq[2]>0){
                tot+=n-right;
                char leftchar=s.charAt(left);
                --freq[leftchar-'a'];
                ++left;
            }
            right++;
        }
     return tot;
    }
}